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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes2.dex */
public class WriteLocationView extends LocationInfoView {
    private final LocationModel.a aCC;
    private LocationModel aCn;
    private int aCu;
    private final CustomMessageListener giI;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCu = 0;
        this.aCC = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Dk() {
                WriteLocationView.this.mBaseActivity.showToast(d.l.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fQ(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.brS())) {
                    WriteLocationView.this.b(2, true, aVar.brS());
                } else {
                    fQ(null);
                }
            }
        };
        this.giI = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aCn.mD(false);
                        WriteLocationView.this.aCn.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aCn.mD(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void e(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.giI);
        this.aCn = new LocationModel(this.mBaseActivity);
        this.aCn.a(this.aCC);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aCu) {
                    case 0:
                        WriteLocationView.this.CW();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.CV();
                        return;
                }
            }
        });
        CY();
    }

    public boolean US() {
        if (this.aCn == null) {
            return false;
        }
        return this.aCn.US();
    }

    public void CW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            CX();
        } else if (this.aCn.bsa()) {
            CV();
        } else {
            this.aCn.mD(false);
            b(1, true, null);
            this.aCn.brY();
        }
    }

    private void CY() {
        if (this.aCn.US()) {
            if (this.aCn.bsa()) {
                b(2, true, c.brW().getLocationData().brS());
                return;
            }
            b(1, true, null);
            this.aCn.brY();
            return;
        }
        b(0, true, null);
    }

    private void CX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.aCn.UW();
                } else {
                    WriteLocationView.this.aCC.Dk();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkE() {
        if (this.aCn != null) {
            this.aCn.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aCu = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
