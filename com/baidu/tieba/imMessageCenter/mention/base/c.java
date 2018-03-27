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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TbPageContext aRI;
    private TextView beW;
    public OriginalThreadCardView cYt;
    private HeadImageView dYK;
    private int ds42;
    private int ds48;
    private TextView duU;
    private TextView eUi;
    private TextView eUj;
    private View eUk;
    private View eUl;
    private TextView eUm;
    private MessageCardBottomView eUn;
    private View eUo;
    private a eUp;
    private OriginalThreadCardView.a eUq;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eUq = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eUp != null && c.this.eUp.aNQ() != null) {
                    ak s = new ak(c.this.eUp.aNQ()).s("obj_locate", 2);
                    if (c.this.eUp.getType() == a.eUd || c.this.eUp.getType() == a.eTZ) {
                        s.s("obj_type", 1);
                    } else {
                        s.s("obj_type", 2);
                    }
                    TiebaStatic.log(s);
                }
                if (c.this.akP() != null) {
                    c.this.akP().a(c.this.cYt, c.this.eUp);
                }
            }
        };
        this.aRI = tbPageContext;
        this.ds42 = l.t(this.aRI.getContext(), d.e.tbds42);
        this.ds48 = l.t(this.aRI.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.dYK = (HeadImageView) view.findViewById(d.g.photo);
        this.beW = (TextView) view.findViewById(d.g.user_name);
        this.eUi = (TextView) view.findViewById(d.g.fans_reply);
        this.eUj = (TextView) view.findViewById(d.g.post_from);
        this.eUk = view.findViewById(d.g.divider_between_time_and_post_from);
        this.duU = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eUl = view.findViewById(d.g.card_message_divider_line);
        this.eUm = (TextView) view.findViewById(d.g.card_message_post_title);
        this.cYt = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eUn = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eUo = view.findViewById(d.g.new_message);
        this.dYK.setOnClickListener(this);
        this.beW.setOnClickListener(this);
        this.eUn.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.beW, d.C0141d.cp_cont_f);
            aj.r(this.eUi, d.C0141d.cp_cont_d);
            aj.s(this.eUi, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            aj.r(this.eUj, d.C0141d.cp_cont_d);
            aj.r(this.duU, d.C0141d.cp_cont_d);
            aj.t(this.eUk, d.C0141d.cp_cont_e);
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.t(this.eUl, d.C0141d.cp_bg_line_c);
            aj.r(this.eUm, d.C0141d.cp_cont_j);
            if (this.cYt != null) {
                this.cYt.onChangeSkinType();
            }
            if (this.eUn != null) {
                this.eUn.onChangeSkinType();
            }
            aj.s(this.eUo, d.f.message_center_red_icon);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.eUp = aVar;
            this.dYK.setVisibility(0);
            this.dYK.setDefaultResource(d.f.icon_default_avatar100);
            this.dYK.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dYK.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.dYK.setIsRound(true);
            this.dYK.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.dYK.setTag(null);
            this.dYK.setPageId(this.aRI.getUniqueId());
            this.dYK.startLoad(portrait, 12, false);
            this.beW.setText(am.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eUi.setVisibility(0);
            } else {
                this.eUi.setVisibility(8);
            }
            if (!am.isEmpty(aVar.getPostFrom())) {
                this.eUk.setVisibility(0);
                this.eUj.setVisibility(0);
                this.eUj.setText(aVar.getPostFrom());
            } else {
                this.eUk.setVisibility(8);
                this.eUj.setVisibility(8);
            }
            this.duU.setText(am.z(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Mw().a(this.aRI.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (am.isEmpty(aVar.getSubTitle())) {
                this.eUl.setVisibility(8);
                this.eUm.setVisibility(8);
            } else {
                this.eUm.setText(a(this.eUm, TbFaceManager.Mw().a(this.aRI.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eUm.setVisibility(0);
                this.eUl.setVisibility(0);
            }
            this.cYt.b(aVar.getOriginalThreadInfo());
            this.cYt.setSubClickListener(this.eUq);
            MessageCardBottomView messageCardBottomView = this.eUn;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eTZ || aVar.getType() == a.eUa) {
                z = false;
            }
            messageCardBottomView.J(fname, z);
            if (aVar.isNew()) {
                this.eUo.setVisibility(0);
            } else {
                this.eUo.setVisibility(8);
            }
            d(this.aRI, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUp != null || this.aRI != null) {
            if (view == this.dYK || view == this.beW) {
                if (this.eUp.getReplyer() != null) {
                    String userId = this.eUp.getReplyer().getUserId();
                    String userName = this.eUp.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aRI.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (akP() != null) {
                akP().a(view, this.eUp);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.aRI == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.ao(this.aRI.getPageActivity()) - (this.aRI.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
