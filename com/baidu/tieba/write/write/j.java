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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class j {
    private static final Pattern hSu = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b gbd;
    private WriteUrlModel hSq;
    private k hSv;
    private com.baidu.tieba.write.model.a hSw;
    private com.baidu.tieba.write.transmit.model.a hSx;
    private com.baidu.tbadk.core.view.d hSy;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bNY();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bNX();
                }
            }
        }
    };
    private View.OnClickListener hSz = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bOl = j.this.hSv.bOl();
                if (j.hSu.matcher(bOl).matches()) {
                    j.this.bNX();
                    j.this.hSw.wY(bOl);
                    j.this.hSv.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.hSv.bOm();
            }
        }
    };
    private TextWatcher hSA = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hSv.bOd();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.gbd != null) {
                if (!j.this.gbd.bKS()) {
                    j.this.oy(false);
                }
                j.this.gbd.op(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hSB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hSx != null) {
                j.this.hSx.aBt();
            }
        }
    };
    private a.InterfaceC0324a hJk = new a.InterfaceC0324a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0324a
        public void onError() {
            j.this.ei(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0324a
        public void h(List<SimpleForum> list, int i) {
            j.this.ei(list);
        }
    };
    private a.InterfaceC0017a bPM = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            j.this.hSv.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.gbd.az(null);
                j.this.gbd.oo(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.gbd.az(postWriteCallBackData.getSensitiveWords());
                    j.this.gbd.wO(postWriteCallBackData.getErrorString());
                    if (!v.I(j.this.gbd.bKP())) {
                        j.this.oy(true);
                    }
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hSv.l(postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.FS());
                    if (!com.baidu.tbadk.q.a.iA(wVar.FR())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.FR())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hSy = null;
        this.mContext = tbPageContext;
        this.hSv = kVar;
        this.hSw = aVar;
        this.hSq = writeUrlModel;
        this.hSv.Z(this.mClickListener);
        this.hSv.aa(this.hSz);
        this.hSv.e(this.hSA);
        bNY();
        this.hSy = new com.baidu.tbadk.core.view.d(this.mContext);
        this.hSy.d(this.hSB);
        bNW();
        this.hSq.b(this.aWI);
        this.gbd = new com.baidu.tieba.write.b();
        this.gbd.wy(e.d.cp_cont_i);
        this.gbd.wz(e.d.cp_cont_h_alpha85);
    }

    private void bNW() {
        this.hSx = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hSx.a(this.hJk);
        if (this.hSq.getWriteData() != null) {
            this.hSx.setForumId(this.hSq.getWriteData().getForumId());
        }
    }

    protected void bNX() {
        this.hSv.bOk();
    }

    protected void bNY() {
        this.hSv.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(List<SimpleForum> list) {
        WriteData writeData = this.hSq.getWriteData();
        if (writeData != null) {
            this.hSy.bz(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.H(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bCe() {
        if (ab.by(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, this.bPM);
        }
    }

    public void destroy() {
        if (this.hSx != null) {
            this.hSx.destroy();
        }
        if (this.hSw != null) {
            this.hSw.destroy();
        }
        if (this.hSq != null) {
            this.hSq.cancelLoadData();
        }
    }

    public void apr() {
        this.hSx.setThreadContent(this.hSv.bOe());
        this.hSx.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oy(boolean z) {
        if (this.hSv.bOg() != null && this.hSv.bOe() != null) {
            int selectionEnd = this.hSv.bOg().getSelectionEnd();
            SpannableStringBuilder b = this.gbd.b(this.hSv.bOg().getText());
            if (b != null) {
                this.gbd.op(true);
                this.hSv.bOg().setText(b);
                if (z && this.gbd.bKQ() >= 0) {
                    this.hSv.bOg().requestFocus();
                    this.hSv.bOg().setSelection(this.gbd.bKQ());
                } else {
                    this.hSv.bOg().setSelection(selectionEnd);
                }
                this.gbd.oo(this.gbd.bKQ() >= 0);
            }
        }
    }

    public boolean bNZ() {
        if (this.gbd.bKR()) {
            this.mContext.showToast(this.gbd.bKT());
            oy(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.gbd.onChangeSkinType();
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
                    this.mContext.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hSq.getWriteData()) != null && this.hSw.bMc() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hSx.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bOa();
                } else if (ab.by(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bOa();
                        }
                    });
                }
                this.hSv.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.gbd.az(postWriteCallBackData.getSensitiveWords());
                        if (!v.I(this.gbd.bKP())) {
                            oy(true);
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

    public void bOa() {
        this.hSq.g("", this.hSv.bOe(), this.hSw.bMc().linkUrl, this.hSw.bMc().linkUrlCode, this.mLat, this.mLng);
    }
}
