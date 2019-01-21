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
    private TextView aLy;
    public OriginalThreadCardView cZN;
    private HeadImageView dap;
    private int ds42;
    private int ds48;
    private TextView dxK;
    private TextView fjF;
    private TextView fjG;
    private View fjH;
    private View fjI;
    private MessageCardBottomView fjJ;
    private View fjK;
    private a fjL;
    private OriginalThreadCardView.a fjM;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.fjM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.fjL != null && c.this.fjL.aXs() != null) {
                    am y = new am(c.this.fjL.aXs()).y("obj_locate", 2);
                    if (c.this.fjL.getType() == a.fjA || c.this.fjL.getType() == a.fjw) {
                        y.y("obj_type", 1);
                    } else {
                        y.y("obj_type", 2);
                    }
                    TiebaStatic.log(y);
                }
                if (c.this.aqp() != null) {
                    c.this.aqp().a(c.this.cZN, c.this.fjL);
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
        this.dap = (HeadImageView) view.findViewById(e.g.photo);
        this.aLy = (TextView) view.findViewById(e.g.user_name);
        this.fjF = (TextView) view.findViewById(e.g.fans_reply);
        this.fjG = (TextView) view.findViewById(e.g.post_from);
        this.fjH = view.findViewById(e.g.divider_between_time_and_post_from);
        this.dxK = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.fjI = view.findViewById(e.g.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cZN = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.fjJ = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.fjK = view.findViewById(e.g.new_message);
        this.dap.setOnClickListener(this);
        this.aLy.setOnClickListener(this);
        this.fjJ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aLy, e.d.cp_cont_f);
            al.h(this.fjF, e.d.cp_cont_d);
            al.i(this.fjF, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.fjG, e.d.cp_cont_d);
            al.h(this.dxK, e.d.cp_cont_d);
            al.j(this.fjH, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.fjI, e.d.cp_bg_line_c);
            al.h(this.mSubTitle, e.d.cp_cont_j);
            if (this.cZN != null) {
                this.cZN.onChangeSkinType();
            }
            if (this.fjJ != null) {
                this.fjJ.onChangeSkinType();
            }
            al.i(this.fjK, e.f.icon_news_red_dot);
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
            this.fjL = aVar;
            this.dap.setVisibility(0);
            this.dap.setDefaultResource(e.f.icon_default_avatar100);
            this.dap.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.dap.setDefaultBgResource(e.d.cp_bg_line_e);
            this.dap.setIsRound(true);
            this.dap.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.dap.setTag(null);
            this.dap.setPageId(this.mContext.getUniqueId());
            this.dap.startLoad(portrait, 12, false);
            this.aLy.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.fjF.setVisibility(0);
            } else {
                this.fjF.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.fjH.setVisibility(0);
                this.fjG.setVisibility(0);
                this.fjG.setText(aVar.getPostFrom());
            } else {
                this.fjH.setVisibility(8);
                this.fjG.setVisibility(8);
            }
            this.dxK.setText(ao.M(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.NL().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.fjI.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.NL().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.fjI.setVisibility(0);
            }
            this.cZN.b(aVar.getOriginalThreadInfo());
            this.cZN.setSubClickListener(this.fjM);
            MessageCardBottomView messageCardBottomView = this.fjJ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.fjw || aVar.getType() == a.fjx) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.fjK.setVisibility(0);
            } else {
                this.fjK.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fjL != null || this.mContext != null) {
            if (view == this.dap || view == this.aLy) {
                if (this.fjL.getReplyer() != null) {
                    String userId = this.fjL.getReplyer().getUserId();
                    String userName = this.fjL.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aqp() != null) {
                aqp().a(view, this.fjL);
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
