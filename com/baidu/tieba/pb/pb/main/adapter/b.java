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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes9.dex */
public class b {
    private LikeModel dYI;
    private PbFragment jHL;
    private com.baidu.tieba.pb.data.e jIA;
    private com.baidu.tieba.pb.data.a jUO;
    private AlertDialog jUP;
    private com.baidu.adp.base.d hMz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.5
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            u uVar;
            boolean z = false;
            if (b.this.jIA != null && b.this.jIA.getForum() != null && obj != null) {
                if (!AntiHelper.bv(b.this.dYI.getErrorCode(), b.this.dYI.getErrorString())) {
                    b.this.jIA.getForum().getName();
                    String id = b.this.jIA.getForum().getId();
                    if (!(obj instanceof u)) {
                        uVar = null;
                    } else {
                        uVar = (u) obj;
                    }
                    boolean z2 = uVar != null && b.this.dYI.getErrorCode() == 0;
                    if (uVar == null || uVar.getErrorCode() != 3250013) {
                        z = z2;
                    } else {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    }
                    if (uVar == null || !z) {
                        if (b.this.dYI.getErrorCode() != 22) {
                            b.this.jHL.showToast(b.this.dYI.getErrorString());
                            return;
                        } else {
                            b.this.jHL.showToast(b.this.jHL.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                            return;
                        }
                    }
                    uVar.setLike(1);
                    b.this.jHL.showToast(b.this.jHL.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
                    b.this.n(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                } else if (AntiHelper.a(b.this.jHL.getContext(), b.this.dYI.getBlockPopInfoData(), b.this.hMy) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
                }
            }
        }
    };
    private AntiHelper.a hMy = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };

    public b(PbFragment pbFragment) {
        this.jHL = pbFragment;
        registerListener();
        Fv();
    }

    private void registerListener() {
        this.jHL.registerListener(new HttpMessageListener(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ) { // from class: com.baidu.tieba.pb.pb.main.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage) {
                    PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                    if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                        b.this.b(pbAdCardGiftItemResponseMessage.getData());
                    } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                        b.this.bq(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                    } else {
                        b.this.jHL.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                    }
                }
            }
        });
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
        tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void c(com.baidu.tieba.pb.data.a aVar) {
        if (aVar != null && aVar.jEQ != null && this.jIA != null && this.jIA.cCy() != null) {
            this.jUO = aVar;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
            httpMessage.addParam("tid", this.jIA.cCy().getTid());
            httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.jEQ.jER);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(final int i, String str) {
        int i2;
        int i3;
        String string;
        if (i == 502014) {
            i2 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i3 = R.string.cancel;
            string = this.jHL.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i2 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.jHL.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.jIA.getForum().getName());
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jHL.getPageContext().getPageActivity());
        aVar.vN(str);
        aVar.vO(string);
        aVar.a(i2, new a.b() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (!k.isFastDoubleClick()) {
                    if (i == 502014) {
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.jHL.getActivity()).createNormalCfg(b.this.jIA.getForum().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                        createNormalCfg.setCallFrom(14);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    } else if (b.this.jHL.checkUpIsLogin()) {
                        if (b.this.dYI == null) {
                            b.this.dYI = new LikeModel(b.this.jHL.getPageContext());
                            b.this.dYI.setLoadDataCallBack(b.this.hMz);
                        }
                        b.this.dYI.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                        b.this.dYI.fq(b.this.jIA.getForum().getName(), String.valueOf(b.this.jIA.getForum().getId()));
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
                b.this.cIO();
            }
        });
        aVar.setTitleShowCenter(true);
        aVar.kH(R.color.cp_cont_b);
        aVar.gX(true);
        aVar.b(this.jHL.getPageContext()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cpA().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.b bVar) {
        if (this.jUO != null) {
            this.jUO.jEQ = bVar;
        }
        if (this.jIA != null && this.jIA.jFh != null) {
            this.jIA.jFh.jEQ = bVar;
        }
        a(this.jUO);
        this.jUP = new AlertDialog.Builder(this.jHL.getPageContext().getPageActivity()).create();
        this.jUP.setCanceledOnTouchOutside(false);
        g.showDialog(this.jUP, this.jHL.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.startLoad(String.valueOf((int) R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jUP.dismiss();
                b.this.b(b.this.jUO);
                ba.aVa().a((TbPageContext<?>) b.this.jHL.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jUP.dismiss();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.jHL.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.card_name}));
        textView2.setText(this.jHL.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.jET}));
        am.setImageResource(imageView, R.drawable.icon_use_close_n);
        am.setViewTextColor(textView2, (int) R.color.cp_cont_j);
        am.setViewTextColor(textView3, (int) R.color.cp_cont_b);
        am.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), (int) R.color.cp_cont_j);
        am.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        am.setViewTextColor(textView, (int) R.color.cp_cont_i);
        this.jUP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.b.9
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.cIO();
            }
        });
        Window window = this.jUP.getWindow();
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str;
        if (aVar != null) {
            String tid = this.jIA.cCy().getTid();
            com.baidu.tieba.s.c.dcI().a(this.jHL.getUniqueId(), com.baidu.tieba.s.a.a(tid, str, "", (BaijiahaoData) null) + "_dialog", com.baidu.tieba.s.a.a(this.jIA.cCy(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, aVar.jEQ.jER + "", "", 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        if (aVar != null) {
            com.baidu.tieba.s.c.dcI().b(this.jHL.getUniqueId(), com.baidu.tieba.s.a.a(this.jIA.cCy(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jEQ.jER + "", "", 19));
        }
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIO() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
    }

    public void onDestroy() {
        if (this.dYI != null) {
            this.dYI.ddc();
        }
        if (this.jUP != null) {
            this.jUP.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }
}
