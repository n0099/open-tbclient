package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.editortools.EditorTools;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class LocationProvidersStatic {

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
            int indexOf = editorTools.getCollectTools().indexOf(7);
            if (indexOf != -1) {
                editorTools.d(new d.b.i0.m1.d.b(editorTools.getContext(), indexOf + 1));
            }
            if (editorTools.getCollectTools().indexOf(8) != -1) {
                if (editorTools.t()) {
                    editorTools.d(new d.b.i0.m1.d.a(editorTools.getContext(), true));
                } else {
                    editorTools.d(new d.b.i0.m1.d.a(editorTools.getContext()));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
            return new CustomResponsedMessage<>(2016556, new d.b.i0.m1.d.b(customMessage.getData(), 0));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Bundle> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Bundle> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                Bundle data = customMessage.getData();
                Address address = (Address) data.getParcelable("location");
                String string = data.getString("coorType");
                if (address != null && !StringUtils.isNULL(string)) {
                    BDLocation bDLocation = new BDLocation();
                    bDLocation.setLatitude(address.getLatitude());
                    bDLocation.setLongitude(address.getLongitude());
                    if (TextUtils.equals(string, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                        bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), BDLocation.BDLOCATION_GCJ02_TO_BD09);
                    } else if (TextUtils.equals(string, "gcj02")) {
                        bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                    } else if (TextUtils.equals(string, CoordinateType.WGS84)) {
                        bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                    }
                    address.setLatitude(bDLocation.getLatitude());
                    address.setLongitude(bDLocation.getLongitude());
                    return new CustomResponsedMessage<>(2921363, address);
                }
            }
            return null;
        }
    }

    static {
        d.b.b.e.i.a.l().p(d.b.i0.m1.b.t());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            d.b.b.e.i.a.l().p(d.b.i0.m1.a.j());
        }
        MessageManager.getInstance().registerListener(new a(2010044));
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921363, new c());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
