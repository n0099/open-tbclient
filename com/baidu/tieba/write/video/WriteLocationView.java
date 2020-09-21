package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel ePj;
    private int ePp;
    private final LocationModel.a ePw;
    private final CustomMessageListener mrc;
    private BaseActivity<?> nby;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePp = 0;
        this.ePw = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void btu() {
                WriteLocationView.this.nby.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.nby;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.nby.getResources().getString(R.string.location_fail);
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
        this.mrc = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.ePj.wp(false);
                        WriteLocationView.this.ePj.gh(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.ePj.wp(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.nby = baseActivity;
        this.nby.registerListener(this.mrc);
        this.ePj = new LocationModel(this.nby.getPageContext());
        this.ePj.a(this.ePw);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.ePp) {
                    case 0:
                        WriteLocationView.this.btf();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.btd();
                        return;
                }
            }
        });
        bti();
    }

    public boolean bZh() {
        if (this.ePj == null) {
            return false;
        }
        return this.ePj.bZh();
    }

    public void btf() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.nby.getPageContext().getPageActivity())) {
            this.nby.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bth();
        } else if (this.ePj.dBl()) {
            btd();
        } else {
            this.ePj.wp(false);
            b(1, true, null);
            this.ePj.dBj();
        }
    }

    private void bti() {
        if (this.ePj.bZh() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.ePj.dBl()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dBg().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.ePj.dBj();
            return;
        }
        b(0, true, null);
    }

    private void bth() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nby.getPageContext().getPageActivity());
        aVar.nE(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.ePj.dBn();
                } else {
                    WriteLocationView.this.ePw.btu();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.nby.getPageContext());
        aVar.bia();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwX() {
        if (this.ePj != null) {
            this.ePj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.nby.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ePp = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
