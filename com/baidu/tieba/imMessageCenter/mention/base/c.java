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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aId;
    private TextView cbV;
    private int ds42;
    private int ds48;
    private HeadImageView eqF;
    public OriginalThreadCardView ezb;
    private TextView faW;
    private TextView gQB;
    private TextView gQC;
    private View gQD;
    private View gQE;
    private MessageCardBottomView gQF;
    private View gQG;
    private a gQH;
    private OriginalThreadCardView.a gQI;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gQI = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gQH != null && c.this.gQH.bFz() != null) {
                    am P = new am(c.this.gQH.bFz()).P("obj_locate", 2);
                    if (c.this.gQH.getType() == a.gQx || c.this.gQH.getType() == a.gQt) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aXo() != null) {
                    c.this.aXo().a(c.this.ezb, c.this.gQH);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.g(this.mContext.getContext(), R.dimen.tbds42);
        this.ds48 = l.g(this.mContext.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eqF = (HeadImageView) view.findViewById(R.id.photo);
        this.cbV = (TextView) view.findViewById(R.id.user_name);
        this.gQB = (TextView) view.findViewById(R.id.fans_reply);
        this.gQC = (TextView) view.findViewById(R.id.post_from);
        this.gQD = view.findViewById(R.id.divider_between_time_and_post_from);
        this.faW = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gQE = view.findViewById(R.id.card_message_divider_line);
        this.aId = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ezb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gQF = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gQG = view.findViewById(R.id.new_message);
        this.eqF.setOnClickListener(this);
        this.cbV.setOnClickListener(this);
        this.gQF.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.j(this.cbV, R.color.cp_cont_f);
            al.j(this.gQB, R.color.cp_cont_d);
            al.k(this.gQB, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gQC, R.color.cp_cont_d);
            al.j(this.faW, R.color.cp_cont_d);
            al.l(this.gQD, R.color.cp_cont_e);
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.gQE, R.color.cp_bg_line_c);
            al.j(this.aId, R.color.cp_cont_j);
            if (this.ezb != null) {
                this.ezb.onChangeSkinType();
            }
            if (this.gQF != null) {
                this.gQF.onChangeSkinType();
            }
            al.k(this.gQG, R.drawable.icon_news_red_dot);
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
            this.gQH = aVar;
            this.eqF.setVisibility(0);
            this.eqF.setDefaultResource(R.drawable.icon_default_avatar100);
            this.eqF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eqF.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eqF.setIsRound(true);
            this.eqF.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eqF.setTag(null);
            this.eqF.setPageId(this.mContext.getUniqueId());
            this.eqF.startLoad(portrait, 12, false);
            this.cbV.setText(ap.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gQB.setVisibility(0);
            } else {
                this.gQB.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gQD.setVisibility(0);
                this.gQC.setVisibility(0);
                this.gQC.setText(aVar.getPostFrom());
            } else {
                this.gQD.setVisibility(8);
                this.gQC.setVisibility(8);
            }
            this.faW.setText(ap.aC(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gQE.setVisibility(8);
                this.aId.setVisibility(8);
            } else {
                this.aId.setText(a(this.aId, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aId.setVisibility(0);
                this.gQE.setVisibility(0);
            }
            this.ezb.b(aVar.getOriginalThreadInfo());
            this.ezb.setSubClickListener(this.gQI);
            MessageCardBottomView messageCardBottomView = this.gQF;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gQt || aVar.getType() == a.gQu) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gQG.setVisibility(0);
            } else {
                this.gQG.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gQH != null || this.mContext != null) {
            if (view == this.eqF || view == this.cbV) {
                if (this.gQH.getReplyer() != null) {
                    String userId = this.gQH.getReplyer().getUserId();
                    String userName = this.gQH.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aXo() != null) {
                aXo().a(view, this.gQH);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.af(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
