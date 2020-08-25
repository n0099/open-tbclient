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
    private final LocationModel.a eMB;
    private LocationModel eMo;
    private int eMu;
    private BaseActivity<?> mRo;
    private final CustomMessageListener mhn;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eMu = 0;
        this.eMB = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bsp() {
                WriteLocationView.this.mRo.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mRo;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mRo.getResources().getString(R.string.location_fail);
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
        this.mhn = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.eMo.we(false);
                        WriteLocationView.this.eMo.fU(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.eMo.we(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.mRo = baseActivity;
        this.mRo.registerListener(this.mhn);
        this.eMo = new LocationModel(this.mRo.getPageContext());
        this.eMo.a(this.eMB);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.eMu) {
                    case 0:
                        WriteLocationView.this.bsa();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.brY();
                        return;
                }
            }
        });
        bsd();
    }

    public boolean bXz() {
        if (this.eMo == null) {
            return false;
        }
        return this.eMo.bXz();
    }

    public void bsa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mRo.getPageContext().getPageActivity())) {
            this.mRo.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsc();
        } else if (this.eMo.dxn()) {
            brY();
        } else {
            this.eMo.we(false);
            b(1, true, null);
            this.eMo.dxl();
        }
    }

    private void bsd() {
        if (this.eMo.bXz() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.eMo.dxn()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.eMo.dxl();
            return;
        }
        b(0, true, null);
    }

    private void bsc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mRo.getPageContext().getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.eMo.dxp();
                } else {
                    WriteLocationView.this.eMB.bsp();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mRo.getPageContext());
        aVar.bhg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsZ() {
        if (this.eMo != null) {
            this.eMo.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mRo.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.eMu = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
