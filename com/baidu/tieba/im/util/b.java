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
/* loaded from: classes17.dex */
public class b {
    private RequestGroupLocModel jky;
    private a jkz;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0021a locationCallBack = new a.InterfaceC0021a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
        public void onLocationGeted(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.jky.setLat(String.valueOf(address.getLatitude()));
                        b.this.jky.setLng(String.valueOf(address.getLongitude()));
                        b.this.jky.setGroupId(0L);
                        b.this.jky.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.jkz.csg();
                    return;
                case 4:
                case 5:
                    b.this.jkz.csf();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jkA = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_QUERY_GROUPLOC) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.jkz.csf();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.jkz.csf();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.jkz.csf();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.jkz.csf();
                } else {
                    b.this.jkz.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes17.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void csf();

        void csg();
    }

    public b(a aVar) {
        this.jky = null;
        this.jkz = null;
        this.jky = new RequestGroupLocModel();
        this.jkz = aVar;
        this.jkA.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.jkA);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.jky.setUniqueId(bdUniqueId);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.kG().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.jky.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jkA);
    }
}
