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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private int ds42;
    private int ds48;
    private TbPageContext eIc;
    private TextView ewx;
    private TextView gmt;
    private HeadImageView hRe;
    public OriginalThreadCardView hZv;
    private TextView kwq;
    private TextView kwr;
    private View kws;
    private View kwt;
    private MessageCardBottomView kwu;
    private View kwv;
    private a kww;
    private OriginalThreadCardView.a kwx;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kwx = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kww != null && c.this.kww.cWX() != null) {
                    aq al = new aq(c.this.kww.cWX()).al("obj_locate", 2);
                    if (c.this.kww.getType() == a.kwm || c.this.kww.getType() == a.kwi) {
                        al.al("obj_type", 1);
                    } else {
                        al.al("obj_type", 2);
                    }
                    TiebaStatic.log(al);
                }
                if (c.this.cnT() != null) {
                    c.this.cnT().a(c.this.hZv, c.this.kww);
                }
            }
        };
        this.eIc = tbPageContext;
        this.ds42 = l.getDimens(this.eIc.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eIc.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hRe = (HeadImageView) view.findViewById(R.id.photo);
        this.ewx = (TextView) view.findViewById(R.id.user_name);
        this.kwq = (TextView) view.findViewById(R.id.fans_reply);
        this.kwr = (TextView) view.findViewById(R.id.post_from);
        this.kws = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gmt = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kwt = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hZv = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kwu = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kwv = view.findViewById(R.id.new_message);
        this.hZv.setUsePlaceHolder(false);
        this.hRe.setOnClickListener(this);
        this.ewx.setOnClickListener(this);
        this.kwu.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oX(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.ewx, R.color.cp_cont_f);
            ap.setViewTextColor(this.kwq, R.color.cp_cont_d);
            ap.setBackgroundResource(this.kwq, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kwr, R.color.cp_cont_d);
            ap.setViewTextColor(this.gmt, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kws, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.kwt, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hZv != null) {
                this.hZv.onChangeSkinType();
            }
            if (this.kwu != null) {
                this.kwu.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kwv, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: f */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.kww = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hRe.setVisibility(0);
            this.hRe.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRe.setPlaceHolder(1);
            this.hRe.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hRe, replyer, 0);
            this.hRe.setTag(null);
            this.hRe.setPageId(this.eIc.getUniqueId());
            this.hRe.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.ewx.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kwq.setVisibility(0);
            } else {
                this.kwq.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.kws.setVisibility(0);
                this.kwr.setVisibility(0);
                this.kwr.setText(aVar.getPostFrom());
            } else {
                this.kws.setVisibility(8);
                this.kwr.setVisibility(8);
            }
            this.gmt.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bBc().b(this.eIc.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.kwt.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bBc().b(this.eIc.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kwt.setVisibility(0);
            }
            this.hZv.b(aVar.getOriginalThreadInfo());
            this.hZv.setSubClickListener(this.kwx);
            MessageCardBottomView messageCardBottomView = this.kwu;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kwi || aVar.getType() == a.kwj) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kwv.setVisibility(0);
            } else {
                this.kwv.setVisibility(8);
            }
            onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kww != null || this.eIc != null) {
            if (view == this.hRe || view == this.ewx) {
                if (this.kww.getReplyer() != null) {
                    String userId = this.kww.getReplyer().getUserId();
                    String userName = this.kww.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eIc.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cnT() != null) {
                cnT().a(view, this.kww);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eIc == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eIc.getPageActivity()) - (this.eIc.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
