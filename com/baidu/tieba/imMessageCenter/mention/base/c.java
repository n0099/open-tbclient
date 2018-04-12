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
    private TextView cNI;
    private HeadImageView cqL;
    public OriginalThreadCardView cqk;
    private int ds42;
    private int ds48;
    private TextView eoO;
    private TextView eoP;
    private View eoQ;
    private View eoR;
    private TextView eoS;
    private MessageCardBottomView eoT;
    private View eoU;
    private a eoV;
    private OriginalThreadCardView.a eoW;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eoW = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eoV != null && c.this.eoV.aIS() != null) {
                    al r = new al(c.this.eoV.aIS()).r("obj_locate", 2);
                    if (c.this.eoV.getType() == a.eoJ || c.this.eoV.getType() == a.eoF) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(c.this.cqk, c.this.eoV);
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
        this.cqL = (HeadImageView) view2.findViewById(d.g.photo);
        this.aqm = (TextView) view2.findViewById(d.g.user_name);
        this.eoO = (TextView) view2.findViewById(d.g.fans_reply);
        this.eoP = (TextView) view2.findViewById(d.g.post_from);
        this.eoQ = view2.findViewById(d.g.divider_between_time_and_post_from);
        this.cNI = (TextView) view2.findViewById(d.g.time);
        this.mTitle = (TextView) view2.findViewById(d.g.card_message_title);
        this.eoR = view2.findViewById(d.g.card_message_divider_line);
        this.eoS = (TextView) view2.findViewById(d.g.card_message_post_title);
        this.cqk = (OriginalThreadCardView) view2.findViewById(d.g.original_thread_view);
        this.eoT = (MessageCardBottomView) view2.findViewById(d.g.card_message_bottom_layout);
        this.eoU = view2.findViewById(d.g.new_message);
        this.cqL.setOnClickListener(this);
        this.aqm.setOnClickListener(this);
        this.eoT.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
            ak.h(this.eoO, d.C0126d.cp_cont_d);
            ak.i(this.eoO, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            ak.h(this.eoP, d.C0126d.cp_cont_d);
            ak.h(this.cNI, d.C0126d.cp_cont_d);
            ak.j(this.eoQ, d.C0126d.cp_cont_e);
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.j(this.eoR, d.C0126d.cp_bg_line_c);
            ak.h(this.eoS, d.C0126d.cp_cont_j);
            if (this.cqk != null) {
                this.cqk.onChangeSkinType();
            }
            if (this.eoT != null) {
                this.eoT.onChangeSkinType();
            }
            ak.i(this.eoU, d.f.icon_news_red_dot);
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
            this.eoV = aVar;
            this.cqL.setVisibility(0);
            this.cqL.setDefaultResource(d.f.icon_default_avatar100);
            this.cqL.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cqL.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.cqL.setIsRound(true);
            this.cqL.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cqL.setTag(null);
            this.cqL.setPageId(this.adf.getUniqueId());
            this.cqL.startLoad(portrait, 12, false);
            this.aqm.setText(an.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eoO.setVisibility(0);
            } else {
                this.eoO.setVisibility(8);
            }
            if (!an.isEmpty(aVar.getPostFrom())) {
                this.eoQ.setVisibility(0);
                this.eoP.setVisibility(0);
                this.eoP.setText(aVar.getPostFrom());
            } else {
                this.eoQ.setVisibility(8);
                this.eoP.setVisibility(8);
            }
            this.cNI.setText(an.s(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.EZ().a(this.adf.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (an.isEmpty(aVar.getSubTitle())) {
                this.eoR.setVisibility(8);
                this.eoS.setVisibility(8);
            } else {
                this.eoS.setText(a(this.eoS, TbFaceManager.EZ().a(this.adf.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eoS.setVisibility(0);
                this.eoR.setVisibility(0);
            }
            this.cqk.b(aVar.getOriginalThreadInfo());
            this.cqk.setSubClickListener(this.eoW);
            MessageCardBottomView messageCardBottomView = this.eoT;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eoF || aVar.getType() == a.eoG) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eoU.setVisibility(0);
            } else {
                this.eoU.setVisibility(8);
            }
            d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.eoV != null || this.adf != null) {
            if (view2 == this.cqL || view2 == this.aqm) {
                if (this.eoV.getReplyer() != null) {
                    String userId = this.eoV.getReplyer().getUserId();
                    String userName = this.eoV.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.adf.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aeZ() != null) {
                aeZ().a(view2, this.eoV);
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
