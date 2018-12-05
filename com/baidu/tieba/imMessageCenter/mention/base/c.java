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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aKT;
    private HeadImageView cWN;
    public OriginalThreadCardView cWl;
    private int ds42;
    private int ds48;
    private TextView dun;
    private TextView ffW;
    private TextView ffX;
    private View ffY;
    private View ffZ;
    private MessageCardBottomView fga;
    private View fgb;
    private a fgc;
    private OriginalThreadCardView.a fgd;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.fgd = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.fgc != null && c.this.fgc.aWf() != null) {
                    am x = new am(c.this.fgc.aWf()).x("obj_locate", 2);
                    if (c.this.fgc.getType() == a.ffR || c.this.fgc.getType() == a.ffN) {
                        x.x("obj_type", 1);
                    } else {
                        x.x("obj_type", 2);
                    }
                    TiebaStatic.log(x);
                }
                if (c.this.apc() != null) {
                    c.this.apc().a(c.this.cWl, c.this.fgc);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), e.C0210e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), e.C0210e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cWN = (HeadImageView) view.findViewById(e.g.photo);
        this.aKT = (TextView) view.findViewById(e.g.user_name);
        this.ffW = (TextView) view.findViewById(e.g.fans_reply);
        this.ffX = (TextView) view.findViewById(e.g.post_from);
        this.ffY = view.findViewById(e.g.divider_between_time_and_post_from);
        this.dun = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.ffZ = view.findViewById(e.g.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cWl = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.fga = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.fgb = view.findViewById(e.g.new_message);
        this.cWN.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.fga.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aKT, e.d.cp_cont_f);
            al.h(this.ffW, e.d.cp_cont_d);
            al.i(this.ffW, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.ffX, e.d.cp_cont_d);
            al.h(this.dun, e.d.cp_cont_d);
            al.j(this.ffY, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.ffZ, e.d.cp_bg_line_c);
            al.h(this.mSubTitle, e.d.cp_cont_j);
            if (this.cWl != null) {
                this.cWl.onChangeSkinType();
            }
            if (this.fga != null) {
                this.fga.onChangeSkinType();
            }
            al.i(this.fgb, e.f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.fgc = aVar;
            this.cWN.setVisibility(0);
            this.cWN.setDefaultResource(e.f.icon_default_avatar100);
            this.cWN.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cWN.setDefaultBgResource(e.d.cp_bg_line_e);
            this.cWN.setIsRound(true);
            this.cWN.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cWN.setTag(null);
            this.cWN.setPageId(this.mContext.getUniqueId());
            this.cWN.startLoad(portrait, 12, false);
            this.aKT.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.ffW.setVisibility(0);
            } else {
                this.ffW.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.ffY.setVisibility(0);
                this.ffX.setVisibility(0);
                this.ffX.setText(aVar.getPostFrom());
            } else {
                this.ffY.setVisibility(8);
                this.ffX.setVisibility(8);
            }
            this.dun.setText(ao.L(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Nt().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.ffZ.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.Nt().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.ffZ.setVisibility(0);
            }
            this.cWl.b(aVar.getOriginalThreadInfo());
            this.cWl.setSubClickListener(this.fgd);
            MessageCardBottomView messageCardBottomView = this.fga;
            String fname = aVar.getFname();
            if (aVar.getType() == a.ffN || aVar.getType() == a.ffO) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.fgb.setVisibility(0);
            } else {
                this.fgb.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fgc != null || this.mContext != null) {
            if (view == this.cWN || view == this.aKT) {
                if (this.fgc.getReplyer() != null) {
                    String userId = this.fgc.getReplyer().getUserId();
                    String userName = this.fgc.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (apc() != null) {
                apc().a(view, this.fgc);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
