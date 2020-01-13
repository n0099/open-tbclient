package com.baidu.tieba.im.util;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.model.RequestGroupLocModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private RequestGroupLocModel hHX;
    private a hHY;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0016a locationCallBack = new a.InterfaceC0016a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.hHX.setLat(String.valueOf(address.getLatitude()));
                        b.this.hHX.setLng(String.valueOf(address.getLongitude()));
                        b.this.hHX.setGroupId(0L);
                        b.this.hHX.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.hHY.bRI();
                    return;
                case 4:
                case 5:
                    b.this.hHY.onLoadFailed();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hHZ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_QUERY_GROUPLOC) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.hHY.onLoadFailed();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.hHY.onLoadFailed();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.hHY.onLoadFailed();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.hHY.onLoadFailed();
                } else {
                    b.this.hHY.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void bRI();

        void onLoadFailed();
    }

    public b(a aVar) {
        this.hHX = null;
        this.hHY = null;
        this.hHX = new RequestGroupLocModel();
        this.hHY = aVar;
        this.hHZ.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.hHZ);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.hHX.setUniqueId(bdUniqueId);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.fK().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.hHX.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hHZ);
    }
}
