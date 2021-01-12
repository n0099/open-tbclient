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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private int ds42;
    private int ds48;
    private TextView dtg;
    private TextView eGI;
    private TbPageContext eSJ;
    private TextView gAE;
    private HeadImageView ikq;
    public OriginalThreadCardView isH;
    private TextView kKZ;
    private TextView kLa;
    private View kLb;
    private View kLc;
    private MessageCardBottomView kLd;
    private View kLe;
    private a kLf;
    private OriginalThreadCardView.a kLg;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kLg = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kLf != null && c.this.kLf.cXE() != null) {
                    aq an = new aq(c.this.kLf.cXE()).an("obj_locate", 2);
                    if (c.this.kLf.getType() == a.kKW || c.this.kLf.getType() == a.kKS) {
                        an.an("obj_type", 1);
                    } else {
                        an.an("obj_type", 2);
                    }
                    TiebaStatic.log(an);
                }
                if (c.this.cqL() != null) {
                    c.this.cqL().a(c.this.isH, c.this.kLf);
                }
            }
        };
        this.eSJ = tbPageContext;
        this.ds42 = l.getDimens(this.eSJ.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eSJ.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ikq = (HeadImageView) view.findViewById(R.id.photo);
        this.eGI = (TextView) view.findViewById(R.id.user_name);
        this.kKZ = (TextView) view.findViewById(R.id.fans_reply);
        this.kLa = (TextView) view.findViewById(R.id.post_from);
        this.kLb = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gAE = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kLc = view.findViewById(R.id.card_message_divider_line);
        this.dtg = (TextView) view.findViewById(R.id.card_message_post_title);
        this.isH = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kLd = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kLe = view.findViewById(R.id.new_message);
        this.isH.setUsePlaceHolder(false);
        this.ikq.setOnClickListener(this);
        this.eGI.setOnClickListener(this);
        this.kLd.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ao.ox(R.color.CAM_X0205));
            ao.setViewTextColor(this.eGI, R.color.CAM_X0106);
            ao.setViewTextColor(this.kKZ, R.color.CAM_X0109);
            ao.setBackgroundResource(this.kKZ, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ao.setViewTextColor(this.kLa, R.color.CAM_X0109);
            ao.setViewTextColor(this.gAE, R.color.CAM_X0109);
            ao.setBackgroundColor(this.kLb, R.color.CAM_X0110);
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setBackgroundColor(this.kLc, R.color.CAM_X0204);
            ao.setViewTextColor(this.dtg, R.color.CAM_X0107);
            if (this.isH != null) {
                this.isH.onChangeSkinType();
            }
            if (this.kLd != null) {
                this.kLd.onChangeSkinType();
            }
            ao.setBackgroundResource(this.kLe, R.drawable.icon_news_red_dot);
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
            this.kLf = aVar;
            MetaData replyer = aVar.getReplyer();
            this.ikq.setVisibility(0);
            this.ikq.setPlaceHolder(1);
            this.ikq.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.ikq, replyer, 0);
            this.ikq.setTag(null);
            this.ikq.setPageId(this.eSJ.getUniqueId());
            this.ikq.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eGI.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kKZ.setVisibility(0);
            } else {
                this.kKZ.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.kLb.setVisibility(0);
                this.kLa.setVisibility(0);
                this.kLa.setText(aVar.getPostFrom());
            } else {
                this.kLb.setVisibility(8);
                this.kLa.setVisibility(8);
            }
            this.gAE.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bCw().b(this.eSJ.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.kLc.setVisibility(8);
                this.dtg.setVisibility(8);
            } else {
                this.dtg.setText(a(this.dtg, TbFaceManager.bCw().b(this.eSJ.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.dtg.setVisibility(0);
                this.kLc.setVisibility(0);
            }
            this.isH.b(aVar.getOriginalThreadInfo());
            this.isH.setSubClickListener(this.kLg);
            MessageCardBottomView messageCardBottomView = this.kLd;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kKS || aVar.getType() == a.kKT) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kLe.setVisibility(0);
            } else {
                this.kLe.setVisibility(8);
            }
            onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kLf != null || this.eSJ != null) {
            if (view == this.ikq || view == this.eGI) {
                if (this.kLf.getReplyer() != null) {
                    String userId = this.kLf.getReplyer().getUserId();
                    String userName = this.kLf.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eSJ.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cqL() != null) {
                cqL().a(view, this.kLf);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eSJ == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eSJ.getPageActivity()) - (this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
