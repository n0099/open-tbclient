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
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes2.dex */
public class WriteLocationView extends LocationInfoView {
    private int evC;
    private final LocationModel.a evJ;
    private LocationModel evw;
    private final CustomMessageListener lIo;
    private BaseActivity<?> mqU;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evC = 0;
        this.evJ = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bfT() {
                WriteLocationView.this.mqU.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mqU;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mqU.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.diB())) {
                    WriteLocationView.this.b(2, true, aVar.diB());
                } else {
                    onFail(null);
                }
            }
        };
        this.lIo = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.evw.uL(false);
                        WriteLocationView.this.evw.fB(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.evw.uL(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mqU = baseActivity;
        this.mqU.registerListener(this.lIo);
        this.evw = new LocationModel(this.mqU.getPageContext());
        this.evw.a(this.evJ);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.evC) {
                    case 0:
                        WriteLocationView.this.bfE();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bfC();
                        return;
                }
            }
        });
        bfH();
    }

    public boolean bKs() {
        if (this.evw == null) {
            return false;
        }
        return this.evw.bKs();
    }

    public void bfE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mqU.getPageContext().getPageActivity())) {
            this.mqU.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bfG();
        } else if (this.evw.diI()) {
            bfC();
        } else {
            this.evw.uL(false);
            b(1, true, null);
            this.evw.diG();
        }
    }

    private void bfH() {
        if (this.evw.bKs() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.evw.diI()) {
                b(2, true, c.diD().getLocationData().diB());
                return;
            }
            b(1, true, null);
            this.evw.diG();
            return;
        }
        b(0, true, null);
    }

    private void bfG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mqU.getPageContext().getPageActivity());
        aVar.kT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.evw.diK();
                } else {
                    WriteLocationView.this.evJ.bfT();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mqU.getPageContext());
        aVar.aUN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void det() {
        if (this.evw != null) {
            this.evw.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mqU.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.evC = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
