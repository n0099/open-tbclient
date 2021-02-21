package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes8.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel fDG;
    private int fDM;
    private final LocationModel.a fDU;
    private final CustomMessageListener nzK;
    private BaseActivity<?> ohS;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDM = 0;
        this.fDU = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bCh() {
                WriteLocationView.this.ohS.showToast(R.string.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.ohS;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.ohS.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    WriteLocationView.this.c(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.nzK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.fDG.yC(false);
                        WriteLocationView.this.fDG.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.fDG.yC(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.fDM = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
