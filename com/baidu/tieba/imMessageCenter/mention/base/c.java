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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private int ds42;
    private int ds48;
    private TextView dvr;
    private TextView eIO;
    private TbPageContext eUY;
    private TextView gDo;
    private HeadImageView ipY;
    public OriginalThreadCardView iyp;
    private TextView kTc;
    private TextView kTd;
    private View kTe;
    private View kTf;
    private MessageCardBottomView kTg;
    private View kTh;
    private a kTi;
    private OriginalThreadCardView.a kTj;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kTj = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kTi != null && c.this.kTi.cZC() != null) {
                    ar ap = new ar(c.this.kTi.cZC()).ap("obj_locate", 2);
                    if (c.this.kTi.getType() == a.kSZ || c.this.kTi.getType() == a.kSV) {
                        ap.ap("obj_type", 1);
                    } else {
                        ap.ap("obj_type", 2);
                    }
                    TiebaStatic.log(ap);
                }
                if (c.this.crV() != null) {
                    c.this.crV().a(c.this.iyp, c.this.kTi);
                }
            }
        };
        this.eUY = tbPageContext;
        this.ds42 = l.getDimens(this.eUY.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eUY.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ipY = (HeadImageView) view.findViewById(R.id.photo);
        this.eIO = (TextView) view.findViewById(R.id.user_name);
        this.kTc = (TextView) view.findViewById(R.id.fans_reply);
        this.kTd = (TextView) view.findViewById(R.id.post_from);
        this.kTe = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gDo = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kTf = view.findViewById(R.id.card_message_divider_line);
        this.dvr = (TextView) view.findViewById(R.id.card_message_post_title);
        this.iyp = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kTg = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kTh = view.findViewById(R.id.new_message);
        this.iyp.setUsePlaceHolder(false);
        this.ipY.setOnClickListener(this);
        this.eIO.setOnClickListener(this);
        this.kTg.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
            ap.setViewTextColor(this.eIO, R.color.CAM_X0106);
            ap.setViewTextColor(this.kTc, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kTc, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kTd, R.color.CAM_X0109);
            ap.setViewTextColor(this.gDo, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kTe, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kTf, R.color.CAM_X0204);
            ap.setViewTextColor(this.dvr, R.color.CAM_X0107);
            if (this.iyp != null) {
                this.iyp.onChangeSkinType();
            }
            if (this.kTg != null) {
                this.kTg.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kTh, R.drawable.icon_news_red_dot);
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
            this.kTi = aVar;
            MetaData replyer = aVar.getReplyer();
            this.ipY.setVisibility(0);
            this.ipY.setPlaceHolder(1);
            this.ipY.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.ipY, replyer, 0);
            this.ipY.setTag(null);
            this.ipY.setPageId(this.eUY.getUniqueId());
            this.ipY.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eIO.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kTc.setVisibility(0);
            } else {
                this.kTc.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kTe.setVisibility(0);
                this.kTd.setVisibility(0);
                this.kTd.setText(aVar.getPostFrom());
            } else {
                this.kTe.setVisibility(8);
                this.kTd.setVisibility(8);
            }
            this.gDo.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bCO().b(this.eUY.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kTf.setVisibility(8);
                this.dvr.setVisibility(8);
            } else {
                this.dvr.setText(a(this.dvr, TbFaceManager.bCO().b(this.eUY.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.dvr.setVisibility(0);
                this.kTf.setVisibility(0);
            }
            this.iyp.b(aVar.getOriginalThreadInfo());
            this.iyp.setSubClickListener(this.kTj);
            MessageCardBottomView messageCardBottomView = this.kTg;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kSV || aVar.getType() == a.kSW) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kTh.setVisibility(0);
            } else {
                this.kTh.setVisibility(8);
            }
            onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kTi != null || this.eUY != null) {
            if (view == this.ipY || view == this.eIO) {
                if (this.kTi.getReplyer() != null) {
                    String userId = this.kTi.getReplyer().getUserId();
                    String userName = this.kTi.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eUY.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (crV() != null) {
                crV().a(view, this.kTi);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eUY == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eUY.getPageActivity()) - (this.eUY.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
