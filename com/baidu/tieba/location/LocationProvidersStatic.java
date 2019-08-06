package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.net.http.Headers;
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
import com.baidu.tbadk.editortools.k;
/* loaded from: classes5.dex */
public class LocationProvidersStatic {
    static {
        com.baidu.adp.lib.d.a.hY().a(b.bLU());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            com.baidu.adp.lib.d.a.hY().a(a.bLT());
        }
        MessageManager.getInstance().registerListener(new CustomMessageListener(2010044) { // from class: com.baidu.tieba.location.LocationProvidersStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                int indexOf = editorTools.getCollectTools().indexOf(7);
                if (indexOf != -1) {
                    editorTools.b(new com.baidu.tieba.location.editortool.b(editorTools.getContext(), indexOf + 1));
                }
                if (editorTools.getCollectTools().indexOf(8) != -1) {
                    if (editorTools.ash()) {
                        editorTools.b(new com.baidu.tieba.location.editortool.a(editorTools.getContext(), true));
                    } else {
                        editorTools.b(new com.baidu.tieba.location.editortool.a(editorTools.getContext()));
                    }
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.location.LocationProvidersStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2016556, new com.baidu.tieba.location.editortool.b(customMessage.getData(), 0));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921363, new CustomMessageTask.CustomRunnable<Bundle>() { // from class: com.baidu.tieba.location.LocationProvidersStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Bundle> customMessage) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                Bundle data = customMessage.getData();
                Address address = (Address) data.getParcelable(Headers.LOCATION);
                String string = data.getString("coorType");
                if (address == null || StringUtils.isNULL(string)) {
                    return null;
                }
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLatitude(address.getLatitude());
                bDLocation.setLongitude(address.getLongitude());
                if (TextUtils.equals(string, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), BDLocation.BDLOCATION_GCJ02_TO_BD09);
                } else if (TextUtils.equals(string, CoordinateType.GCJ02)) {
                    bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                } else if (TextUtils.equals(string, CoordinateType.WGS84)) {
                    bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                }
                address.setLatitude(bDLocation.getLatitude());
                address.setLongitude(bDLocation.getLongitude());
                return new CustomResponsedMessage<>(2921363, address);
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
