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
    private TextView cbW;
    private int ds42;
    private int ds48;
    private HeadImageView eqG;
    public OriginalThreadCardView ezc;
    private TextView faX;
    private TextView gQG;
    private TextView gQH;
    private View gQI;
    private View gQJ;
    private MessageCardBottomView gQK;
    private View gQL;
    private a gQM;
    private OriginalThreadCardView.a gQN;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gQN = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gQM != null && c.this.gQM.bFD() != null) {
                    am P = new am(c.this.gQM.bFD()).P("obj_locate", 2);
                    if (c.this.gQM.getType() == a.gQC || c.this.gQM.getType() == a.gQy) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aXr() != null) {
                    c.this.aXr().a(c.this.ezc, c.this.gQM);
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
        this.eqG = (HeadImageView) view.findViewById(R.id.photo);
        this.cbW = (TextView) view.findViewById(R.id.user_name);
        this.gQG = (TextView) view.findViewById(R.id.fans_reply);
        this.gQH = (TextView) view.findViewById(R.id.post_from);
        this.gQI = view.findViewById(R.id.divider_between_time_and_post_from);
        this.faX = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gQJ = view.findViewById(R.id.card_message_divider_line);
        this.aId = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ezc = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gQK = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gQL = view.findViewById(R.id.new_message);
        this.eqG.setOnClickListener(this);
        this.cbW.setOnClickListener(this);
        this.gQK.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.j(this.cbW, R.color.cp_cont_f);
            al.j(this.gQG, R.color.cp_cont_d);
            al.k(this.gQG, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gQH, R.color.cp_cont_d);
            al.j(this.faX, R.color.cp_cont_d);
            al.l(this.gQI, R.color.cp_cont_e);
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.gQJ, R.color.cp_bg_line_c);
            al.j(this.aId, R.color.cp_cont_j);
            if (this.ezc != null) {
                this.ezc.onChangeSkinType();
            }
            if (this.gQK != null) {
                this.gQK.onChangeSkinType();
            }
            al.k(this.gQL, R.drawable.icon_news_red_dot);
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
            this.gQM = aVar;
            this.eqG.setVisibility(0);
            this.eqG.setDefaultResource(R.drawable.icon_default_avatar100);
            this.eqG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eqG.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eqG.setIsRound(true);
            this.eqG.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eqG.setTag(null);
            this.eqG.setPageId(this.mContext.getUniqueId());
            this.eqG.startLoad(portrait, 12, false);
            this.cbW.setText(ap.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gQG.setVisibility(0);
            } else {
                this.gQG.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gQI.setVisibility(0);
                this.gQH.setVisibility(0);
                this.gQH.setText(aVar.getPostFrom());
            } else {
                this.gQI.setVisibility(8);
                this.gQH.setVisibility(8);
            }
            this.faX.setText(ap.aC(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gQJ.setVisibility(8);
                this.aId.setVisibility(8);
            } else {
                this.aId.setText(a(this.aId, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aId.setVisibility(0);
                this.gQJ.setVisibility(0);
            }
            this.ezc.b(aVar.getOriginalThreadInfo());
            this.ezc.setSubClickListener(this.gQN);
            MessageCardBottomView messageCardBottomView = this.gQK;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gQy || aVar.getType() == a.gQz) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gQL.setVisibility(0);
            } else {
                this.gQL.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gQM != null || this.mContext != null) {
            if (view == this.eqG || view == this.cbW) {
                if (this.gQM.getReplyer() != null) {
                    String userId = this.gQM.getReplyer().getUserId();
                    String userName = this.gQM.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aXr() != null) {
                aXr().a(view, this.gQM);
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
