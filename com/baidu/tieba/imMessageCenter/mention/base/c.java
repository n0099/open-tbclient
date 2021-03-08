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
    private TextView dwS;
    private TextView eKp;
    private TbPageContext eWx;
    private TextView gFl;
    public OriginalThreadCardView iAm;
    private HeadImageView irV;
    private TextView kVs;
    private TextView kVt;
    private View kVu;
    private View kVv;
    private MessageCardBottomView kVw;
    private View kVx;
    private a kVy;
    private OriginalThreadCardView.a kVz;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kVz = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kVy != null && c.this.kVy.cZQ() != null) {
                    ar aq = new ar(c.this.kVy.cZQ()).aq("obj_locate", 2);
                    if (c.this.kVy.getType() == a.kVp || c.this.kVy.getType() == a.kVl) {
                        aq.aq("obj_type", 1);
                    } else {
                        aq.aq("obj_type", 2);
                    }
                    TiebaStatic.log(aq);
                }
                if (c.this.csi() != null) {
                    c.this.csi().a(c.this.iAm, c.this.kVy);
                }
            }
        };
        this.eWx = tbPageContext;
        this.ds42 = l.getDimens(this.eWx.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eWx.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.irV = (HeadImageView) view.findViewById(R.id.photo);
        this.eKp = (TextView) view.findViewById(R.id.user_name);
        this.kVs = (TextView) view.findViewById(R.id.fans_reply);
        this.kVt = (TextView) view.findViewById(R.id.post_from);
        this.kVu = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gFl = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kVv = view.findViewById(R.id.card_message_divider_line);
        this.dwS = (TextView) view.findViewById(R.id.card_message_post_title);
        this.iAm = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kVw = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kVx = view.findViewById(R.id.new_message);
        this.iAm.setUsePlaceHolder(false);
        this.irV.setOnClickListener(this);
        this.eKp.setOnClickListener(this);
        this.kVw.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oD(R.color.CAM_X0205));
            ap.setViewTextColor(this.eKp, R.color.CAM_X0106);
            ap.setViewTextColor(this.kVs, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kVs, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kVt, R.color.CAM_X0109);
            ap.setViewTextColor(this.gFl, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kVu, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kVv, R.color.CAM_X0204);
            ap.setViewTextColor(this.dwS, R.color.CAM_X0107);
            if (this.iAm != null) {
                this.iAm.onChangeSkinType();
            }
            if (this.kVw != null) {
                this.kVw.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kVx, R.drawable.icon_news_red_dot);
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
            this.kVy = aVar;
            MetaData replyer = aVar.getReplyer();
            this.irV.setVisibility(0);
            this.irV.setPlaceHolder(1);
            this.irV.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.irV, replyer, 0);
            this.irV.setTag(null);
            this.irV.setPageId(this.eWx.getUniqueId());
            this.irV.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eKp.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kVs.setVisibility(0);
            } else {
                this.kVs.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kVu.setVisibility(0);
                this.kVt.setVisibility(0);
                this.kVt.setText(aVar.getPostFrom());
            } else {
                this.kVu.setVisibility(8);
                this.kVt.setVisibility(8);
            }
            this.gFl.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bCR().b(this.eWx.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kVv.setVisibility(8);
                this.dwS.setVisibility(8);
            } else {
                this.dwS.setText(a(this.dwS, TbFaceManager.bCR().b(this.eWx.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.dwS.setVisibility(0);
                this.kVv.setVisibility(0);
            }
            this.iAm.b(aVar.getOriginalThreadInfo());
            this.iAm.setSubClickListener(this.kVz);
            MessageCardBottomView messageCardBottomView = this.kVw;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kVl || aVar.getType() == a.kVm) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kVx.setVisibility(0);
            } else {
                this.kVx.setVisibility(8);
            }
            onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kVy != null || this.eWx != null) {
            if (view == this.irV || view == this.eKp) {
                if (this.kVy.getReplyer() != null) {
                    String userId = this.kVy.getReplyer().getUserId();
                    String userName = this.kVy.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eWx.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (csi() != null) {
                csi().a(view, this.kVy);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eWx == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eWx.getPageActivity()) - (this.eWx.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
