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
    private TextView gDC;
    private HeadImageView iqm;
    public OriginalThreadCardView iyD;
    private TextView kTq;
    private TextView kTr;
    private View kTs;
    private View kTt;
    private MessageCardBottomView kTu;
    private View kTv;
    private a kTw;
    private OriginalThreadCardView.a kTx;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kTx = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kTw != null && c.this.kTw.cZJ() != null) {
                    ar ap = new ar(c.this.kTw.cZJ()).ap("obj_locate", 2);
                    if (c.this.kTw.getType() == a.kTn || c.this.kTw.getType() == a.kTj) {
                        ap.ap("obj_type", 1);
                    } else {
                        ap.ap("obj_type", 2);
                    }
                    TiebaStatic.log(ap);
                }
                if (c.this.csc() != null) {
                    c.this.csc().a(c.this.iyD, c.this.kTw);
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
        this.iqm = (HeadImageView) view.findViewById(R.id.photo);
        this.eIO = (TextView) view.findViewById(R.id.user_name);
        this.kTq = (TextView) view.findViewById(R.id.fans_reply);
        this.kTr = (TextView) view.findViewById(R.id.post_from);
        this.kTs = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gDC = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kTt = view.findViewById(R.id.card_message_divider_line);
        this.dvr = (TextView) view.findViewById(R.id.card_message_post_title);
        this.iyD = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kTu = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kTv = view.findViewById(R.id.new_message);
        this.iyD.setUsePlaceHolder(false);
        this.iqm.setOnClickListener(this);
        this.eIO.setOnClickListener(this);
        this.kTu.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
            ap.setViewTextColor(this.eIO, R.color.CAM_X0106);
            ap.setViewTextColor(this.kTq, R.color.CAM_X0109);
            ap.setBackgroundResource(this.kTq, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.kTr, R.color.CAM_X0109);
            ap.setViewTextColor(this.gDC, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kTs, R.color.CAM_X0110);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kTt, R.color.CAM_X0204);
            ap.setViewTextColor(this.dvr, R.color.CAM_X0107);
            if (this.iyD != null) {
                this.iyD.onChangeSkinType();
            }
            if (this.kTu != null) {
                this.kTu.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kTv, R.drawable.icon_news_red_dot);
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
            this.kTw = aVar;
            MetaData replyer = aVar.getReplyer();
            this.iqm.setVisibility(0);
            this.iqm.setPlaceHolder(1);
            this.iqm.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.iqm, replyer, 0);
            this.iqm.setTag(null);
            this.iqm.setPageId(this.eUY.getUniqueId());
            this.iqm.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eIO.setText(au.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kTq.setVisibility(0);
            } else {
                this.kTq.setVisibility(8);
            }
            if (!au.isEmpty(aVar.getPostFrom())) {
                this.kTs.setVisibility(0);
                this.kTr.setVisibility(0);
                this.kTr.setText(aVar.getPostFrom());
            } else {
                this.kTs.setVisibility(8);
                this.kTr.setVisibility(8);
            }
            this.gDC.setText(au.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bCO().b(this.eUY.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (au.isEmpty(aVar.getSubTitle())) {
                this.kTt.setVisibility(8);
                this.dvr.setVisibility(8);
            } else {
                this.dvr.setText(a(this.dvr, TbFaceManager.bCO().b(this.eUY.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.dvr.setVisibility(0);
                this.kTt.setVisibility(0);
            }
            this.iyD.b(aVar.getOriginalThreadInfo());
            this.iyD.setSubClickListener(this.kTx);
            MessageCardBottomView messageCardBottomView = this.kTu;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kTj || aVar.getType() == a.kTk) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kTv.setVisibility(0);
            } else {
                this.kTv.setVisibility(8);
            }
            onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kTw != null || this.eUY != null) {
            if (view == this.iqm || view == this.eIO) {
                if (this.kTw.getReplyer() != null) {
                    String userId = this.kTw.getReplyer().getUserId();
                    String userName = this.kTw.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eUY.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (csc() != null) {
                csc().a(view, this.kTw);
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
