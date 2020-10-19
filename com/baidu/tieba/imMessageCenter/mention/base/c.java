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
    private TextView eig;
    private TbPageContext etO;
    private TextView fWB;
    public OriginalThreadCardView hHb;
    private HeadImageView hyL;
    private TextView kdV;
    private TextView kdW;
    private View kdX;
    private View kdY;
    private MessageCardBottomView kdZ;
    private View kea;
    private a keb;
    private OriginalThreadCardView.a kec;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kec = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.keb != null && c.this.keb.cRp() != null) {
                    aq aj = new aq(c.this.keb.cRp()).aj("obj_locate", 2);
                    if (c.this.keb.getType() == a.kdR || c.this.keb.getType() == a.kdN) {
                        aj.aj("obj_type", 1);
                    } else {
                        aj.aj("obj_type", 2);
                    }
                    TiebaStatic.log(aj);
                }
                if (c.this.cil() != null) {
                    c.this.cil().a(c.this.hHb, c.this.keb);
                }
            }
        };
        this.etO = tbPageContext;
        this.ds42 = l.getDimens(this.etO.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.etO.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hyL = (HeadImageView) view.findViewById(R.id.photo);
        this.eig = (TextView) view.findViewById(R.id.user_name);
        this.kdV = (TextView) view.findViewById(R.id.fans_reply);
        this.kdW = (TextView) view.findViewById(R.id.post_from);
        this.kdX = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fWB = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kdY = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hHb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kdZ = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kea = view.findViewById(R.id.new_message);
        this.hHb.setUsePlaceHolder(false);
        this.hyL.setOnClickListener(this);
        this.eig.setOnClickListener(this);
        this.kdZ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.eig, R.color.cp_cont_f);
            ap.setViewTextColor(this.kdV, R.color.cp_cont_d);
            ap.setBackgroundResource(this.kdV, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kdW, R.color.cp_cont_d);
            ap.setViewTextColor(this.fWB, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kdX, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.kdY, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hHb != null) {
                this.hHb.onChangeSkinType();
            }
            if (this.kdZ != null) {
                this.kdZ.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kea, R.drawable.icon_news_red_dot);
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
            this.keb = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hyL.setVisibility(0);
            this.hyL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hyL.setPlaceHolder(1);
            this.hyL.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hyL, replyer, 0);
            this.hyL.setTag(null);
            this.hyL.setPageId(this.etO.getUniqueId());
            this.hyL.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eig.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kdV.setVisibility(0);
            } else {
                this.kdV.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.kdX.setVisibility(0);
                this.kdW.setVisibility(0);
                this.kdW.setText(aVar.getPostFrom());
            } else {
                this.kdX.setVisibility(8);
                this.kdW.setVisibility(8);
            }
            this.fWB.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bwK().b(this.etO.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.kdY.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bwK().b(this.etO.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.kdY.setVisibility(0);
            }
            this.hHb.b(aVar.getOriginalThreadInfo());
            this.hHb.setSubClickListener(this.kec);
            MessageCardBottomView messageCardBottomView = this.kdZ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kdN || aVar.getType() == a.kdO) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kea.setVisibility(0);
            } else {
                this.kea.setVisibility(8);
            }
            onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.keb != null || this.etO != null) {
            if (view == this.hyL || view == this.eig) {
                if (this.keb.getReplyer() != null) {
                    String userId = this.keb.getReplyer().getUserId();
                    String userName = this.keb.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.etO.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cil() != null) {
                cil().a(view, this.keb);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.etO == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.etO.getPageActivity()) - (this.etO.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
