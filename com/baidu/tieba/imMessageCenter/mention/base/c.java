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
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private int ds42;
    private int ds48;
    private TbPageContext eGu;
    private TextView euO;
    private TextView gma;
    private HeadImageView hRE;
    public OriginalThreadCardView hZV;
    private TextView kxa;
    private TextView kxb;
    private View kxc;
    private View kxd;
    private MessageCardBottomView kxe;
    private View kxf;
    private a kxg;
    private OriginalThreadCardView.a kxh;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kxh = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kxg != null && c.this.kxg.cWE() != null) {
                    ar ak = new ar(c.this.kxg.cWE()).ak("obj_locate", 2);
                    if (c.this.kxg.getType() == a.kwW || c.this.kxg.getType() == a.kwS) {
                        ak.ak("obj_type", 1);
                    } else {
                        ak.ak("obj_type", 2);
                    }
                    TiebaStatic.log(ak);
                }
                if (c.this.cnv() != null) {
                    c.this.cnv().a(c.this.hZV, c.this.kxg);
                }
            }
        };
        this.eGu = tbPageContext;
        this.ds42 = l.getDimens(this.eGu.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eGu.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hRE = (HeadImageView) view.findViewById(R.id.photo);
        this.euO = (TextView) view.findViewById(R.id.user_name);
        this.kxa = (TextView) view.findViewById(R.id.fans_reply);
        this.kxb = (TextView) view.findViewById(R.id.post_from);
        this.kxc = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gma = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kxd = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hZV = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kxe = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kxf = view.findViewById(R.id.new_message);
        this.hZV.setUsePlaceHolder(false);
        this.hRE.setOnClickListener(this);
        this.euO.setOnClickListener(this);
        this.kxe.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.pt(R.color.CAM_X0205));
            ap.setViewTextColor(this.euO, R.color.CAM_X0106);
            ap.setViewTextColor(this.kxa, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kxa, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kxb, R.color.CAM_X0109);
            ap.setViewTextColor(this.gma, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kxc, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kxd, R.color.CAM_X0204);
            ap.setViewTextColor(this.mSubTitle, R.color.CAM_X0107);
            if (this.hZV != null) {
                this.hZV.onChangeSkinType();
            }
            if (this.kxe != null) {
                this.kxe.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kxf, R.drawable.icon_news_red_dot);
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
            this.kxg = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hRE.setVisibility(0);
            this.hRE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRE.setPlaceHolder(1);
            this.hRE.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hRE, replyer, 0);
            this.hRE.setTag(null);
            this.hRE.setPageId(this.eGu.getUniqueId());
            this.hRE.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.euO.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kxa.setVisibility(0);
            } else {
                this.kxa.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kxc.setVisibility(0);
                this.kxb.setVisibility(0);
                this.kxb.setText(aVar.getPostFrom());
            } else {
                this.kxc.setVisibility(8);
                this.kxb.setVisibility(8);
            }
            this.gma.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bAs().b(this.eGu.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kxd.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bAs().b(this.eGu.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kxd.setVisibility(0);
            }
            this.hZV.b(aVar.getOriginalThreadInfo());
            this.hZV.setSubClickListener(this.kxh);
            MessageCardBottomView messageCardBottomView = this.kxe;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kwS || aVar.getType() == a.kwT) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kxf.setVisibility(0);
            } else {
                this.kxf.setVisibility(8);
            }
            onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kxg != null || this.eGu != null) {
            if (view == this.hRE || view == this.euO) {
                if (this.kxg.getReplyer() != null) {
                    String userId = this.kxg.getReplyer().getUserId();
                    String userName = this.kxg.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eGu.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cnv() != null) {
                cnv().a(view, this.kxg);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eGu == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eGu.getPageActivity()) - (this.eGu.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
