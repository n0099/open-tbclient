package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class i {
    private static final Pattern hMz = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aRG;
    public com.baidu.tieba.write.b fZy;
    private j hMA;
    private com.baidu.tieba.write.model.a hMB;
    private com.baidu.tieba.write.transmit.model.a hMC;
    private com.baidu.tbadk.core.view.b hMD;
    private WriteUrlModel hMv;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bJj();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bJi();
                }
            }
        }
    };
    private View.OnClickListener hME = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bJw = i.this.hMA.bJw();
                if (i.hMz.matcher(bJw).matches()) {
                    i.this.bJi();
                    i.this.hMB.uv(bJw);
                    i.this.hMA.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hMA.bJx();
            }
        }
    };
    private TextWatcher hMF = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hMA.bJo();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fZy != null) {
                if (!i.this.fZy.bFE()) {
                    i.this.nJ(false);
                }
                i.this.fZy.nB(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hMG = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hMC != null) {
                i.this.hMC.awO();
            }
        }
    };
    private a.InterfaceC0254a hDh = new a.InterfaceC0254a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void onError() {
            i.this.dZ(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void t(List<SimpleForum> list, int i) {
            i.this.dZ(list);
        }
    };
    private a.InterfaceC0017a cga = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            i.this.hMA.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fZy.aw(null);
                i.this.fZy.nA(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aRG.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aRG.getPageActivity().setResult(-1, intent);
                    i.this.aRG.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aRG.showToast(postWriteCallBackData.getErrorString());
                    i.this.fZy.aw(postWriteCallBackData.getSensitiveWords());
                    i.this.fZy.un(postWriteCallBackData.getErrorString());
                    if (!v.E(i.this.fZy.bFB())) {
                        i.this.nJ(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hMA.k(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FX());
                    if (!com.baidu.tbadk.p.a.hx(tVar.FW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(i.this.aRG.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(i.this.aRG.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FW())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(i.this.aRG.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hMD = null;
        this.aRG = tbPageContext;
        this.hMA = jVar;
        this.hMB = aVar;
        this.hMv = writeUrlModel;
        this.hMA.U(this.mClickListener);
        this.hMA.V(this.hME);
        this.hMA.e(this.hMF);
        bJj();
        this.hMD = new com.baidu.tbadk.core.view.b(this.aRG);
        this.hMD.d(this.hMG);
        bJh();
        this.hMv.b(this.buj);
        this.fZy = new com.baidu.tieba.write.b();
        this.fZy.xg(d.C0141d.cp_cont_i);
        this.fZy.xh(d.C0141d.cp_cont_h_alpha85);
    }

    private void bJh() {
        this.hMC = new com.baidu.tieba.write.transmit.model.a(this.aRG.getUniqueId());
        this.hMC.a(this.hDh);
        if (this.hMv.getWriteData() != null) {
            this.hMC.setForumId(this.hMv.getWriteData().getForumId());
        }
    }

    protected void bJi() {
        this.hMA.bJv();
    }

    protected void bJj() {
        this.hMA.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(List<SimpleForum> list) {
        WriteData writeData = this.hMv.getWriteData();
        if (writeData != null) {
            this.hMD.bq(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.D(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aRG.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bxB() {
        if (ab.aR(this.aRG.getPageActivity())) {
            com.baidu.adp.lib.d.a.mG().a(true, this.cga);
        }
    }

    public void destroy() {
        if (this.hMC != null) {
            this.hMC.destroy();
        }
        if (this.hMB != null) {
            this.hMB.destroy();
        }
        if (this.hMv != null) {
            this.hMv.cancelLoadData();
        }
    }

    public void and() {
        this.hMC.setThreadContent(this.hMA.bJp());
        this.hMC.Ws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (this.hMA.bJr() != null && this.hMA.bJp() != null) {
            int selectionEnd = this.hMA.bJr().getSelectionEnd();
            SpannableStringBuilder b = this.fZy.b(this.hMA.bJr().getText());
            if (b != null) {
                this.fZy.nB(true);
                this.hMA.bJr().setText(b);
                if (z && this.fZy.bFC() >= 0) {
                    this.hMA.bJr().requestFocus();
                    this.hMA.bJr().setSelection(this.fZy.bFC());
                } else {
                    this.hMA.bJr().setSelection(selectionEnd);
                }
                this.fZy.nA(this.fZy.bFC() >= 0);
            }
        }
    }

    public boolean bJk() {
        if (this.fZy.bFD()) {
            this.aRG.showToast(this.fZy.bFF());
            nJ(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fZy.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.aRG.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hMv.getWriteData()) != null && this.hMB.bGR() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hMC.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJl();
                } else if (ab.aR(this.aRG.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mG().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bJl();
                        }
                    });
                }
                this.hMA.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aRG.showToast(postWriteCallBackData.getErrorString());
                        this.fZy.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.fZy.bFB())) {
                            nJ(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bJl() {
        this.hMv.e("", this.hMA.bJp(), this.hMB.bGR().linkUrl, this.hMB.bGR().linkUrlCode, this.mLat, this.mLng);
    }
}
