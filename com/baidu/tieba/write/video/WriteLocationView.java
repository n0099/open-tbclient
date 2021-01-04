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
    private LocationModel fFZ;
    private int fGf;
    private final LocationModel.a fGm;
    private final CustomMessageListener nug;
    private BaseActivity<?> obS;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGf = 0;
        this.fGm = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bFH() {
                WriteLocationView.this.obS.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.obS;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.obS.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    WriteLocationView.this.b(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.nug = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.fFZ.yn(false);
                        WriteLocationView.this.fFZ.gv(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.fFZ.yn(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fGf = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
