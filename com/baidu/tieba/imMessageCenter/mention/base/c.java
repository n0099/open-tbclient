package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView bcf;
    private TbPageContext ceu;
    private TextView crw;
    private int ds42;
    private int ds48;
    private TextView dyg;
    private HeadImageView eFo;
    public OriginalThreadCardView eNF;
    private TextView gWM;
    private TextView gWN;
    private View gWO;
    private View gWP;
    private MessageCardBottomView gWQ;
    private View gWR;
    private a gWS;
    private OriginalThreadCardView.a gWT;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gWT = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gWS != null && c.this.gWS.bFU() != null) {
                    an O = new an(c.this.gWS.bFU()).O("obj_locate", 2);
                    if (c.this.gWS.getType() == a.gWI || c.this.gWS.getType() == a.gWE) {
                        O.O("obj_type", 1);
                    } else {
                        O.O("obj_type", 2);
                    }
                    TiebaStatic.log(O);
                }
                if (c.this.aZV() != null) {
                    c.this.aZV().a(c.this.eNF, c.this.gWS);
                }
            }
        };
        this.ceu = tbPageContext;
        this.ds42 = l.getDimens(this.ceu.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.ceu.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eFo = (HeadImageView) view.findViewById(R.id.photo);
        this.crw = (TextView) view.findViewById(R.id.user_name);
        this.gWM = (TextView) view.findViewById(R.id.fans_reply);
        this.gWN = (TextView) view.findViewById(R.id.post_from);
        this.gWO = view.findViewById(R.id.divider_between_time_and_post_from);
        this.dyg = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gWP = view.findViewById(R.id.card_message_divider_line);
        this.bcf = (TextView) view.findViewById(R.id.card_message_post_title);
        this.eNF = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gWQ = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gWR = view.findViewById(R.id.new_message);
        this.eFo.setOnClickListener(this);
        this.crw.setOnClickListener(this);
        this.gWQ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
            am.setViewTextColor(this.crw, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gWM, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.gWM, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.gWN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dyg, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.gWO, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.gWP, R.color.cp_bg_line_c);
            am.setViewTextColor(this.bcf, (int) R.color.cp_cont_j);
            if (this.eNF != null) {
                this.eNF.onChangeSkinType();
            }
            if (this.gWQ != null) {
                this.gWQ.onChangeSkinType();
            }
            am.setBackgroundResource(this.gWR, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.gWS = aVar;
            this.eFo.setVisibility(0);
            this.eFo.setDefaultResource(R.drawable.icon_default_avatar100);
            this.eFo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eFo.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eFo.setIsRound(true);
            this.eFo.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eFo.setTag(null);
            this.eFo.setPageId(this.ceu.getUniqueId());
            this.eFo.startLoad(portrait, 12, false);
            this.crw.setText(aq.cutChineseAndEnglishWithSuffix(aVar.getReplyer().getName_show(), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gWM.setVisibility(0);
            } else {
                this.gWM.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.gWO.setVisibility(0);
                this.gWN.setVisibility(0);
                this.gWN.setText(aVar.getPostFrom());
            } else {
                this.gWO.setVisibility(8);
                this.gWN.setVisibility(8);
            }
            this.dyg.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.avr().b(this.ceu.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.gWP.setVisibility(8);
                this.bcf.setVisibility(8);
            } else {
                this.bcf.setText(a(this.bcf, TbFaceManager.avr().b(this.ceu.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.bcf.setVisibility(0);
                this.gWP.setVisibility(0);
            }
            this.eNF.b(aVar.getOriginalThreadInfo());
            this.eNF.setSubClickListener(this.gWT);
            MessageCardBottomView messageCardBottomView = this.gWQ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gWE || aVar.getType() == a.gWF) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gWR.setVisibility(0);
            } else {
                this.gWR.setVisibility(8);
            }
            onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gWS != null || this.ceu != null) {
            if (view == this.eFo || view == this.crw) {
                if (this.gWS.getReplyer() != null) {
                    String userId = this.gWS.getReplyer().getUserId();
                    String userName = this.gWS.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ceu.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aZV() != null) {
                aZV().a(view, this.gWS);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.ceu == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.ceu.getPageActivity()) - (this.ceu.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
