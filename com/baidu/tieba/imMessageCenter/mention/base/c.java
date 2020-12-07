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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private int ds42;
    private int ds48;
    private TextView eBQ;
    private TbPageContext eNx;
    private TextView guj;
    private HeadImageView icx;
    public OriginalThreadCardView ikR;
    private OriginalThreadCardView.a kKA;
    private TextView kKt;
    private TextView kKu;
    private View kKv;
    private View kKw;
    private MessageCardBottomView kKx;
    private View kKy;
    private a kKz;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kKA = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kKz != null && c.this.kKz.dbQ() != null) {
                    ar al = new ar(c.this.kKz.dbQ()).al("obj_locate", 2);
                    if (c.this.kKz.getType() == a.kKq || c.this.kKz.getType() == a.kKm) {
                        al.al("obj_type", 1);
                    } else {
                        al.al("obj_type", 2);
                    }
                    TiebaStatic.log(al);
                }
                if (c.this.crI() != null) {
                    c.this.crI().a(c.this.ikR, c.this.kKz);
                }
            }
        };
        this.eNx = tbPageContext;
        this.ds42 = l.getDimens(this.eNx.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eNx.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.icx = (HeadImageView) view.findViewById(R.id.photo);
        this.eBQ = (TextView) view.findViewById(R.id.user_name);
        this.kKt = (TextView) view.findViewById(R.id.fans_reply);
        this.kKu = (TextView) view.findViewById(R.id.post_from);
        this.kKv = view.findViewById(R.id.divider_between_time_and_post_from);
        this.guj = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kKw = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ikR = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kKx = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kKy = view.findViewById(R.id.new_message);
        this.ikR.setUsePlaceHolder(false);
        this.icx.setOnClickListener(this);
        this.eBQ.setOnClickListener(this);
        this.kKx.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0106);
            ap.setViewTextColor(this.kKt, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kKt, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kKu, R.color.CAM_X0109);
            ap.setViewTextColor(this.guj, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kKv, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kKw, R.color.CAM_X0204);
            ap.setViewTextColor(this.mSubTitle, R.color.CAM_X0107);
            if (this.ikR != null) {
                this.ikR.onChangeSkinType();
            }
            if (this.kKx != null) {
                this.kKx.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kKy, R.drawable.icon_news_red_dot);
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
            this.kKz = aVar;
            MetaData replyer = aVar.getReplyer();
            this.icx.setVisibility(0);
            this.icx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.icx.setPlaceHolder(1);
            this.icx.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.icx, replyer, 0);
            this.icx.setTag(null);
            this.icx.setPageId(this.eNx.getUniqueId());
            this.icx.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kKt.setVisibility(0);
            } else {
                this.kKt.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kKv.setVisibility(0);
                this.kKu.setVisibility(0);
                this.kKu.setText(aVar.getPostFrom());
            } else {
                this.kKv.setVisibility(8);
                this.kKu.setVisibility(8);
            }
            this.guj.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bDU().b(this.eNx.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kKw.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bDU().b(this.eNx.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kKw.setVisibility(0);
            }
            this.ikR.b(aVar.getOriginalThreadInfo());
            this.ikR.setSubClickListener(this.kKA);
            MessageCardBottomView messageCardBottomView = this.kKx;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kKm || aVar.getType() == a.kKn) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kKy.setVisibility(0);
            } else {
                this.kKy.setVisibility(8);
            }
            onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kKz != null || this.eNx != null) {
            if (view == this.icx || view == this.eBQ) {
                if (this.kKz.getReplyer() != null) {
                    String userId = this.kKz.getReplyer().getUserId();
                    String userName = this.kKz.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eNx.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (crI() != null) {
                crI().a(view, this.kKz);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eNx == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eNx.getPageActivity()) - (this.eNx.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
