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
    private TextView gul;
    private HeadImageView icz;
    public OriginalThreadCardView ikT;
    private View kKA;
    private a kKB;
    private OriginalThreadCardView.a kKC;
    private TextView kKv;
    private TextView kKw;
    private View kKx;
    private View kKy;
    private MessageCardBottomView kKz;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kKC = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kKB != null && c.this.kKB.dbR() != null) {
                    ar al = new ar(c.this.kKB.dbR()).al("obj_locate", 2);
                    if (c.this.kKB.getType() == a.kKs || c.this.kKB.getType() == a.kKo) {
                        al.al("obj_type", 1);
                    } else {
                        al.al("obj_type", 2);
                    }
                    TiebaStatic.log(al);
                }
                if (c.this.crJ() != null) {
                    c.this.crJ().a(c.this.ikT, c.this.kKB);
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
        this.icz = (HeadImageView) view.findViewById(R.id.photo);
        this.eBQ = (TextView) view.findViewById(R.id.user_name);
        this.kKv = (TextView) view.findViewById(R.id.fans_reply);
        this.kKw = (TextView) view.findViewById(R.id.post_from);
        this.kKx = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gul = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kKy = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ikT = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kKz = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kKA = view.findViewById(R.id.new_message);
        this.ikT.setUsePlaceHolder(false);
        this.icz.setOnClickListener(this);
        this.eBQ.setOnClickListener(this);
        this.kKz.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0106);
            ap.setViewTextColor(this.kKv, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kKv, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kKw, R.color.CAM_X0109);
            ap.setViewTextColor(this.gul, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kKx, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kKy, R.color.CAM_X0204);
            ap.setViewTextColor(this.mSubTitle, R.color.CAM_X0107);
            if (this.ikT != null) {
                this.ikT.onChangeSkinType();
            }
            if (this.kKz != null) {
                this.kKz.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kKA, R.drawable.icon_news_red_dot);
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
            this.kKB = aVar;
            MetaData replyer = aVar.getReplyer();
            this.icz.setVisibility(0);
            this.icz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.icz.setPlaceHolder(1);
            this.icz.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.icz, replyer, 0);
            this.icz.setTag(null);
            this.icz.setPageId(this.eNx.getUniqueId());
            this.icz.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kKv.setVisibility(0);
            } else {
                this.kKv.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kKx.setVisibility(0);
                this.kKw.setVisibility(0);
                this.kKw.setText(aVar.getPostFrom());
            } else {
                this.kKx.setVisibility(8);
                this.kKw.setVisibility(8);
            }
            this.gul.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bDU().b(this.eNx.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kKy.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bDU().b(this.eNx.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kKy.setVisibility(0);
            }
            this.ikT.b(aVar.getOriginalThreadInfo());
            this.ikT.setSubClickListener(this.kKC);
            MessageCardBottomView messageCardBottomView = this.kKz;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kKo || aVar.getType() == a.kKp) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kKA.setVisibility(0);
            } else {
                this.kKA.setVisibility(8);
            }
            onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kKB != null || this.eNx != null) {
            if (view == this.icz || view == this.eBQ) {
                if (this.kKB.getReplyer() != null) {
                    String userId = this.kKB.getReplyer().getUserId();
                    String userName = this.kKB.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eNx.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (crJ() != null) {
                crJ().a(view, this.kKB);
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
