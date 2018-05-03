package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TbPageContext adf;
    private TextView aqm;
    private TextView cNF;
    private HeadImageView cqI;
    public OriginalThreadCardView cqh;
    private int ds42;
    private int ds48;
    private TextView eoL;
    private TextView eoM;
    private View eoN;
    private View eoO;
    private TextView eoP;
    private MessageCardBottomView eoQ;
    private View eoR;
    private a eoS;
    private OriginalThreadCardView.a eoT;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eoT = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eoS != null && c.this.eoS.aIS() != null) {
                    al r = new al(c.this.eoS.aIS()).r("obj_locate", 2);
                    if (c.this.eoS.getType() == a.eoG || c.this.eoS.getType() == a.eoC) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(c.this.cqh, c.this.eoS);
                }
            }
        };
        this.adf = tbPageContext;
        this.ds42 = l.e(this.adf.getContext(), d.e.tbds42);
        this.ds48 = l.e(this.adf.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view2 = getView();
        this.cqI = (HeadImageView) view2.findViewById(d.g.photo);
        this.aqm = (TextView) view2.findViewById(d.g.user_name);
        this.eoL = (TextView) view2.findViewById(d.g.fans_reply);
        this.eoM = (TextView) view2.findViewById(d.g.post_from);
        this.eoN = view2.findViewById(d.g.divider_between_time_and_post_from);
        this.cNF = (TextView) view2.findViewById(d.g.time);
        this.mTitle = (TextView) view2.findViewById(d.g.card_message_title);
        this.eoO = view2.findViewById(d.g.card_message_divider_line);
        this.eoP = (TextView) view2.findViewById(d.g.card_message_post_title);
        this.cqh = (OriginalThreadCardView) view2.findViewById(d.g.original_thread_view);
        this.eoQ = (MessageCardBottomView) view2.findViewById(d.g.card_message_bottom_layout);
        this.eoR = view2.findViewById(d.g.new_message);
        this.cqI.setOnClickListener(this);
        this.aqm.setOnClickListener(this);
        this.eoQ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
            ak.h(this.eoL, d.C0126d.cp_cont_d);
            ak.i(this.eoL, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            ak.h(this.eoM, d.C0126d.cp_cont_d);
            ak.h(this.cNF, d.C0126d.cp_cont_d);
            ak.j(this.eoN, d.C0126d.cp_cont_e);
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.j(this.eoO, d.C0126d.cp_bg_line_c);
            ak.h(this.eoP, d.C0126d.cp_cont_j);
            if (this.cqh != null) {
                this.cqh.onChangeSkinType();
            }
            if (this.eoQ != null) {
                this.eoQ.onChangeSkinType();
            }
            ak.i(this.eoR, d.f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.eoS = aVar;
            this.cqI.setVisibility(0);
            this.cqI.setDefaultResource(d.f.icon_default_avatar100);
            this.cqI.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cqI.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.cqI.setIsRound(true);
            this.cqI.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cqI.setTag(null);
            this.cqI.setPageId(this.adf.getUniqueId());
            this.cqI.startLoad(portrait, 12, false);
            this.aqm.setText(an.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eoL.setVisibility(0);
            } else {
                this.eoL.setVisibility(8);
            }
            if (!an.isEmpty(aVar.getPostFrom())) {
                this.eoN.setVisibility(0);
                this.eoM.setVisibility(0);
                this.eoM.setText(aVar.getPostFrom());
            } else {
                this.eoN.setVisibility(8);
                this.eoM.setVisibility(8);
            }
            this.cNF.setText(an.s(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.EZ().a(this.adf.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (an.isEmpty(aVar.getSubTitle())) {
                this.eoO.setVisibility(8);
                this.eoP.setVisibility(8);
            } else {
                this.eoP.setText(a(this.eoP, TbFaceManager.EZ().a(this.adf.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eoP.setVisibility(0);
                this.eoO.setVisibility(0);
            }
            this.cqh.b(aVar.getOriginalThreadInfo());
            this.cqh.setSubClickListener(this.eoT);
            MessageCardBottomView messageCardBottomView = this.eoQ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eoC || aVar.getType() == a.eoD) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eoR.setVisibility(0);
            } else {
                this.eoR.setVisibility(8);
            }
            d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.eoS != null || this.adf != null) {
            if (view2 == this.cqI || view2 == this.aqm) {
                if (this.eoS.getReplyer() != null) {
                    String userId = this.eoS.getReplyer().getUserId();
                    String userName = this.eoS.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.adf.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aeZ() != null) {
                aeZ().a(view2, this.eoS);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.adf == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.af(this.adf.getPageActivity()) - (this.adf.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
