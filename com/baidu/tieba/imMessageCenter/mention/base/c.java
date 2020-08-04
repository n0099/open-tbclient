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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private TextView dKI;
    private TbPageContext dVN;
    private int ds42;
    private int ds48;
    private TextView fvC;
    private HeadImageView gPX;
    public OriginalThreadCardView gYh;
    private TextView jrr;
    private TextView jrs;
    private View jrt;
    private View jru;
    private MessageCardBottomView jrv;
    private View jrw;
    private a jrx;
    private OriginalThreadCardView.a jry;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.jry = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.jrx != null && c.this.jrx.czj() != null) {
                    ap ah = new ap(c.this.jrx.czj()).ah("obj_locate", 2);
                    if (c.this.jrx.getType() == a.jrn || c.this.jrx.getType() == a.jrj) {
                        ah.ah("obj_type", 1);
                    } else {
                        ah.ah("obj_type", 2);
                    }
                    TiebaStatic.log(ah);
                }
                if (c.this.bRn() != null) {
                    c.this.bRn().a(c.this.gYh, c.this.jrx);
                }
            }
        };
        this.dVN = tbPageContext;
        this.ds42 = l.getDimens(this.dVN.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.dVN.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gPX = (HeadImageView) view.findViewById(R.id.photo);
        this.dKI = (TextView) view.findViewById(R.id.user_name);
        this.jrr = (TextView) view.findViewById(R.id.fans_reply);
        this.jrs = (TextView) view.findViewById(R.id.post_from);
        this.jrt = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fvC = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.jru = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gYh = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.jrv = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.jrw = view.findViewById(R.id.new_message);
        this.gYh.setUsePlaceHolder(false);
        this.gPX.setOnClickListener(this);
        this.dKI.setOnClickListener(this);
        this.jrv.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
            ao.setViewTextColor(this.dKI, R.color.cp_cont_f);
            ao.setViewTextColor(this.jrr, R.color.cp_cont_d);
            ao.setBackgroundResource(this.jrr, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ao.setViewTextColor(this.jrs, R.color.cp_cont_d);
            ao.setViewTextColor(this.fvC, R.color.cp_cont_d);
            ao.setBackgroundColor(this.jrt, R.color.cp_cont_e);
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ao.setBackgroundColor(this.jru, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.gYh != null) {
                this.gYh.onChangeSkinType();
            }
            if (this.jrv != null) {
                this.jrv.onChangeSkinType();
            }
            ao.setBackgroundResource(this.jrw, R.drawable.icon_news_red_dot);
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
            this.jrx = aVar;
            MetaData replyer = aVar.getReplyer();
            this.gPX.setVisibility(0);
            this.gPX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gPX.setPlaceHolder(1);
            this.gPX.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.gPX, replyer, 0);
            this.gPX.setTag(null);
            this.gPX.setPageId(this.dVN.getUniqueId());
            this.gPX.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dKI.setText(as.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.jrr.setVisibility(0);
            } else {
                this.jrr.setVisibility(8);
            }
            if (!as.isEmpty(aVar.getPostFrom())) {
                this.jrt.setVisibility(0);
                this.jrs.setVisibility(0);
                this.jrs.setText(aVar.getPostFrom());
            } else {
                this.jrt.setVisibility(8);
                this.jrs.setVisibility(8);
            }
            this.fvC.setText(as.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bkj().b(this.dVN.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (as.isEmpty(aVar.getSubTitle())) {
                this.jru.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bkj().b(this.dVN.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.jru.setVisibility(0);
            }
            this.gYh.b(aVar.getOriginalThreadInfo());
            this.gYh.setSubClickListener(this.jry);
            MessageCardBottomView messageCardBottomView = this.jrv;
            String fname = aVar.getFname();
            if (aVar.getType() == a.jrj || aVar.getType() == a.jrk) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.jrw.setVisibility(0);
            } else {
                this.jrw.setVisibility(8);
            }
            onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jrx != null || this.dVN != null) {
            if (view == this.gPX || view == this.dKI) {
                if (this.jrx.getReplyer() != null) {
                    String userId = this.jrx.getReplyer().getUserId();
                    String userName = this.jrx.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dVN.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bRn() != null) {
                bRn().a(view, this.jrx);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.dVN == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.dVN.getPageActivity()) - (this.dVN.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
