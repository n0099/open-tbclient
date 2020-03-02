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
/* loaded from: classes13.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel dyl;
    private int dyr;
    private final LocationModel.a dyy;
    private BaseActivity<?> kQn;
    private final CustomMessageListener kiW;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyr = 0;
        this.dyy = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPk() {
                WriteLocationView.this.kQn.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.kQn;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.kQn.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLE())) {
                    WriteLocationView.this.b(2, true, aVar.cLE());
                } else {
                    onFail(null);
                }
            }
        };
        this.kiW = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dyl.sQ(false);
                        WriteLocationView.this.dyl.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dyl.sQ(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.kQn = baseActivity;
        this.kQn.registerListener(this.kiW);
        this.dyl = new LocationModel(this.kQn.getPageContext());
        this.dyl.a(this.dyy);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dyr) {
                    case 0:
                        WriteLocationView.this.aOV();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aOU();
                        return;
                }
            }
        });
        aOY();
    }

    public boolean brl() {
        if (this.dyl == null) {
            return false;
        }
        return this.dyl.brl();
    }

    public void aOV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.kQn.getPageContext().getPageActivity())) {
            this.kQn.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOX();
        } else if (this.dyl.cLL()) {
            aOU();
        } else {
            this.dyl.sQ(false);
            b(1, true, null);
            this.dyl.cLJ();
        }
    }

    private void aOY() {
        if (this.dyl.brl() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dyl.cLL()) {
                b(2, true, c.cLG().getLocationData().cLE());
                return;
            }
            b(1, true, null);
            this.dyl.cLJ();
            return;
        }
        b(0, true, null);
    }

    private void aOX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kQn.getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.dyl.cLN();
                } else {
                    WriteLocationView.this.dyy.aPk();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.kQn.getPageContext());
        aVar.aEC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cHS() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.kQn.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dyr = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
