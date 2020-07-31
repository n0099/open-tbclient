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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes16.dex */
public class b {
    private LikeModel emT;
    private PbFragment kjZ;
    private f kkM;
    private com.baidu.tieba.pb.data.a kxC;
    private AlertDialog kxD;
    private com.baidu.adp.base.d ifN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.5
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            u uVar;
            boolean z = false;
            if (b.this.kkM != null && b.this.kkM.getForum() != null && obj != null) {
                if (!AntiHelper.bB(b.this.emT.getErrorCode(), b.this.emT.getErrorString())) {
                    b.this.kkM.getForum().getName();
                    String id = b.this.kkM.getForum().getId();
                    if (!(obj instanceof u)) {
                        uVar = null;
                    } else {
                        uVar = (u) obj;
                    }
                    boolean z2 = uVar != null && b.this.emT.getErrorCode() == 0;
                    if (uVar == null || uVar.getErrorCode() != 3250013) {
                        z = z2;
                    } else {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                    }
                    if (uVar == null || !z) {
                        if (b.this.emT.getErrorCode() != 22) {
                            b.this.kjZ.showToast(b.this.emT.getErrorString());
                            return;
                        } else {
                            b.this.kjZ.showToast(b.this.kjZ.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                            return;
                        }
                    }
                    uVar.setLike(1);
                    b.this.kjZ.showToast(b.this.kjZ.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
                    b.this.p(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                } else if (AntiHelper.a(b.this.kjZ.getContext(), b.this.emT.getBlockPopInfoData(), b.this.ifM) != null) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
                }
            }
        }
    };
    private AntiHelper.a ifM = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
        }
    };

    public b(PbFragment pbFragment) {
        this.kjZ = pbFragment;
        registerListener();
        registerTask();
    }

    private void registerListener() {
        this.kjZ.registerListener(new HttpMessageListener(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ) { // from class: com.baidu.tieba.pb.pb.main.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage) {
                    PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                    if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                        b.this.b(pbAdCardGiftItemResponseMessage.getData());
                    } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                        b.this.bv(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                    } else {
                        b.this.kjZ.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
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
        if (aVar != null && aVar.kha != null && this.kkM != null && this.kkM.cKx() != null) {
            this.kxC = aVar;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
            httpMessage.addParam("tid", this.kkM.cKx().getTid());
            httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.kha.khb);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(final int i, String str) {
        int i2;
        int i3;
        String string;
        if (i == 502014) {
            i2 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i3 = R.string.cancel;
            string = this.kjZ.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i2 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.kjZ.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.kkM.getForum().getName());
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kjZ.getPageContext().getPageActivity());
        aVar.xk(str);
        aVar.xl(string);
        aVar.a(i2, new a.b() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (!k.isFastDoubleClick()) {
                    if (i == 502014) {
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.kjZ.getActivity()).createNormalCfg(b.this.kkM.getForum().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                        createNormalCfg.setCallFrom(14);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    } else if (b.this.kjZ.checkUpIsLogin()) {
                        if (b.this.emT == null) {
                            b.this.emT = new LikeModel(b.this.kjZ.getPageContext());
                            b.this.emT.setLoadDataCallBack(b.this.ifN);
                        }
                        b.this.emT.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                        b.this.emT.fz(b.this.kkM.getForum().getName(), String.valueOf(b.this.kkM.getForum().getId()));
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
        aVar.b(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.cQT();
            }
        });
        aVar.setTitleShowCenter(true);
        aVar.lp(R.color.cp_cont_b);
        aVar.hK(true);
        aVar.b(this.kjZ.getPageContext()).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cxs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.b bVar) {
        if (this.kxC != null) {
            this.kxC.kha = bVar;
        }
        if (this.kkM != null && this.kkM.khs != null) {
            this.kkM.khs.kha = bVar;
        }
        a(this.kxC);
        this.kxD = new AlertDialog.Builder(this.kjZ.getPageContext().getPageActivity()).create();
        this.kxD.setCanceledOnTouchOutside(false);
        g.showDialog(this.kxD, this.kjZ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.startLoad(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kxD.dismiss();
                b.this.b(b.this.kxC);
                bd.baV().a((TbPageContext<?>) b.this.kjZ.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kxD.dismiss();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.kjZ.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.card_name}));
        textView2.setText(this.kjZ.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.khd}));
        ao.setImageResource(imageView, R.drawable.icon_use_close_n);
        ao.setViewTextColor(textView2, R.color.cp_cont_j);
        ao.setViewTextColor(textView3, R.color.cp_cont_b);
        ao.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.cp_cont_j);
        ao.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        ao.setViewTextColor(textView, R.color.cp_cont_i);
        this.kxD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.9
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.cQT();
            }
        });
        Window window = this.kxD.getWindow();
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str;
        if (aVar != null) {
            String tid = this.kkM.cKx().getTid();
            com.baidu.tieba.s.c.dkh().a(this.kjZ.getUniqueId(), com.baidu.tieba.s.a.a(tid, str, "", (BaijiahaoData) null) + "_dialog", com.baidu.tieba.s.a.a(this.kkM.cKx(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, aVar.kha.khb + "", "", 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        if (aVar != null) {
            com.baidu.tieba.s.c.dkh().b(this.kjZ.getUniqueId(), com.baidu.tieba.s.a.a(this.kkM.cKx(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kha.khb + "", "", 19));
        }
    }

    public void setData(f fVar) {
        this.kkM = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQT() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
    }

    public void onDestroy() {
        if (this.emT != null) {
            this.emT.dkA();
        }
        if (this.kxD != null) {
            this.kxD.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }
}
