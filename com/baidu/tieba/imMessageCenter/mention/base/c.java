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
    private TbPageContext eCn;
    private TextView eqE;
    private TextView ggF;
    private HeadImageView hLh;
    public OriginalThreadCardView hTy;
    private a kqA;
    private OriginalThreadCardView.a kqB;
    private TextView kqu;
    private TextView kqv;
    private View kqw;
    private View kqx;
    private MessageCardBottomView kqy;
    private View kqz;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kqB = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kqA != null && c.this.kqA.cUw() != null) {
                    aq aj = new aq(c.this.kqA.cUw()).aj("obj_locate", 2);
                    if (c.this.kqA.getType() == a.kqq || c.this.kqA.getType() == a.kqm) {
                        aj.aj("obj_type", 1);
                    } else {
                        aj.aj("obj_type", 2);
                    }
                    TiebaStatic.log(aj);
                }
                if (c.this.cls() != null) {
                    c.this.cls().a(c.this.hTy, c.this.kqA);
                }
            }
        };
        this.eCn = tbPageContext;
        this.ds42 = l.getDimens(this.eCn.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eCn.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hLh = (HeadImageView) view.findViewById(R.id.photo);
        this.eqE = (TextView) view.findViewById(R.id.user_name);
        this.kqu = (TextView) view.findViewById(R.id.fans_reply);
        this.kqv = (TextView) view.findViewById(R.id.post_from);
        this.kqw = view.findViewById(R.id.divider_between_time_and_post_from);
        this.ggF = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kqx = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hTy = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kqy = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kqz = view.findViewById(R.id.new_message);
        this.hTy.setUsePlaceHolder(false);
        this.hLh.setOnClickListener(this);
        this.eqE.setOnClickListener(this);
        this.kqy.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oN(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.eqE, R.color.cp_cont_f);
            ap.setViewTextColor(this.kqu, R.color.cp_cont_d);
            ap.setBackgroundResource(this.kqu, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kqv, R.color.cp_cont_d);
            ap.setViewTextColor(this.ggF, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kqw, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.kqx, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hTy != null) {
                this.hTy.onChangeSkinType();
            }
            if (this.kqy != null) {
                this.kqy.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kqz, R.drawable.icon_news_red_dot);
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
            this.kqA = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hLh.setVisibility(0);
            this.hLh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hLh.setPlaceHolder(1);
            this.hLh.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hLh, replyer, 0);
            this.hLh.setTag(null);
            this.hLh.setPageId(this.eCn.getUniqueId());
            this.hLh.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eqE.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kqu.setVisibility(0);
            } else {
                this.kqu.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.kqw.setVisibility(0);
                this.kqv.setVisibility(0);
                this.kqv.setText(aVar.getPostFrom());
            } else {
                this.kqw.setVisibility(8);
                this.kqv.setVisibility(8);
            }
            this.ggF.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.byD().b(this.eCn.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.kqx.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.byD().b(this.eCn.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kqx.setVisibility(0);
            }
            this.hTy.b(aVar.getOriginalThreadInfo());
            this.hTy.setSubClickListener(this.kqB);
            MessageCardBottomView messageCardBottomView = this.kqy;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kqm || aVar.getType() == a.kqn) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kqz.setVisibility(0);
            } else {
                this.kqz.setVisibility(8);
            }
            onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kqA != null || this.eCn != null) {
            if (view == this.hLh || view == this.eqE) {
                if (this.kqA.getReplyer() != null) {
                    String userId = this.kqA.getReplyer().getUserId();
                    String userName = this.kqA.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eCn.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cls() != null) {
                cls().a(view, this.kqA);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eCn == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eCn.getPageActivity()) - (this.eCn.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
