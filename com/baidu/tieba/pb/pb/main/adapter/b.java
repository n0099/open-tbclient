package com.baidu.tieba.pb.pb.main.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes21.dex */
public class b {
    private LikeModel ezi;
    private PbFragment kHX;
    private f kIK;
    private com.baidu.tieba.pb.data.a kVQ;
    private AlertDialog kVR;
    private com.baidu.adp.base.d iBv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.5
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            v vVar;
            boolean z = false;
            if (b.this.kIK != null && b.this.kIK.getForum() != null && obj != null) {
                if (!AntiHelper.bC(b.this.ezi.getErrorCode(), b.this.ezi.getErrorString())) {
                    b.this.kIK.getForum().getName();
                    String id = b.this.kIK.getForum().getId();
                    if (!(obj instanceof v)) {
                        vVar = null;
                    } else {
                        vVar = (v) obj;
                    }
                    boolean z2 = vVar != null && b.this.ezi.getErrorCode() == 0;
                    if (vVar == null || vVar.getErrorCode() != 3250013) {
                        z = z2;
                    } else {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                    }
                    if (vVar == null || !z) {
                        if (b.this.ezi.getErrorCode() != 22) {
                            b.this.kHX.showToast(b.this.ezi.getErrorString());
                            return;
                        } else {
                            b.this.kHX.showToast(b.this.kHX.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                            return;
                        }
                    }
                    vVar.setLike(1);
                    b.this.kHX.showToast(b.this.kHX.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
                    b.this.q(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                } else if (AntiHelper.a(b.this.kHX.getContext(), b.this.ezi.getBlockPopInfoData(), b.this.iBu) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                }
            }
        }
    };
    private AntiHelper.a iBu = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };

    public b(PbFragment pbFragment) {
        this.kHX = pbFragment;
        registerListener();
        registerTask();
    }

    private void registerListener() {
        this.kHX.registerListener(new HttpMessageListener(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ) { // from class: com.baidu.tieba.pb.pb.main.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage) {
                    PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                    if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                        b.this.b(pbAdCardGiftItemResponseMessage.getData());
                    } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                        b.this.bw(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                    } else {
                        b.this.kHX.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                    }
                }
            }
        });
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
        tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void c(com.baidu.tieba.pb.data.a aVar) {
        if (aVar != null && aVar.kFb != null && this.kIK != null && this.kIK.cYR() != null) {
            this.kVQ = aVar;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
            httpMessage.addParam("tid", this.kIK.cYR().getTid());
            httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.kFb.kFc);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(final int i, String str) {
        int i2;
        int i3;
        String string;
        if (i == 502014) {
            i2 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i3 = R.string.cancel;
            string = this.kHX.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i2 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.kHX.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.kIK.getForum().getName());
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHX.getPageContext().getPageActivity());
        aVar.zU(str);
        aVar.zV(string);
        aVar.a(i2, new a.b() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (!l.isFastDoubleClick()) {
                    if (i == 502014) {
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.kHX.getActivity()).createNormalCfg(b.this.kIK.getForum().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                        createNormalCfg.setCallFrom(14);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    } else if (b.this.kHX.checkUpIsLogin()) {
                        if (b.this.ezi == null) {
                            b.this.ezi = new LikeModel(b.this.kHX.getPageContext());
                            b.this.ezi.setLoadDataCallBack(b.this.iBv);
                        }
                        b.this.ezi.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                        b.this.ezi.gd(b.this.kIK.getForum().getName(), String.valueOf(b.this.kIK.getForum().getId()));
                    } else {
                        return;
                    }
                    aVar2.dismiss();
                }
            }
        });
        aVar.b(i3, new a.b() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.dfo();
            }
        });
        aVar.setTitleShowCenter(true);
        aVar.nG(R.color.cp_cont_b);
        aVar.ie(true);
        aVar.b(this.kHX.getPageContext()).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cLQ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.b bVar) {
        if (this.kVQ != null) {
            this.kVQ.kFb = bVar;
        }
        if (this.kIK != null && this.kIK.kFt != null) {
            this.kIK.kFt.kFb = bVar;
        }
        a(this.kVQ);
        this.kVR = new AlertDialog.Builder(this.kHX.getPageContext().getPageActivity()).create();
        this.kVR.setCanceledOnTouchOutside(false);
        g.showDialog(this.kVR, this.kHX.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.startLoad(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kVR.dismiss();
                b.this.b(b.this.kVQ);
                be.bkp().a((TbPageContext<?>) b.this.kHX.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kVR.dismiss();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.kHX.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.card_name}));
        textView2.setText(this.kHX.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.kFe}));
        ap.setImageResource(imageView, R.drawable.icon_use_close_n);
        ap.setViewTextColor(textView2, R.color.cp_cont_j);
        ap.setViewTextColor(textView3, R.color.cp_cont_b);
        ap.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.cp_cont_j);
        ap.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        ap.setViewTextColor(textView, R.color.cp_cont_i);
        this.kVR.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.9
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.dfo();
            }
        });
        Window window = this.kVR.getWindow();
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str;
        if (aVar != null) {
            String tid = this.kIK.cYR().getTid();
            com.baidu.tieba.s.c.dzC().a(this.kHX.getUniqueId(), com.baidu.tieba.s.a.a(tid, str, "", (BaijiahaoData) null) + "_dialog", com.baidu.tieba.s.a.a(this.kIK.cYR(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, aVar.kFb.kFc + "", "", 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        if (aVar != null) {
            com.baidu.tieba.s.c.dzC().b(this.kHX.getUniqueId(), com.baidu.tieba.s.a.a(this.kIK.cYR(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kFb.kFc + "", "", 19));
        }
    }

    public void setData(f fVar) {
        this.kIK = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfo() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
    }

    public void onDestroy() {
        if (this.ezi != null) {
            this.ezi.dzW();
        }
        if (this.kVR != null) {
            this.kVR.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }
}
