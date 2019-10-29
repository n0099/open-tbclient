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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView bcx;
    private TbPageContext cfl;
    private TextView csn;
    private int ds42;
    private int ds48;
    private TextView dyX;
    private HeadImageView eGf;
    public OriginalThreadCardView eOw;
    private TextView gXD;
    private TextView gXE;
    private View gXF;
    private View gXG;
    private MessageCardBottomView gXH;
    private View gXI;
    private a gXJ;
    private OriginalThreadCardView.a gXK;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gXK = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gXJ != null && c.this.gXJ.bFW() != null) {
                    an O = new an(c.this.gXJ.bFW()).O("obj_locate", 2);
                    if (c.this.gXJ.getType() == a.gXz || c.this.gXJ.getType() == a.gXv) {
                        O.O("obj_type", 1);
                    } else {
                        O.O("obj_type", 2);
                    }
                    TiebaStatic.log(O);
                }
                if (c.this.aZX() != null) {
                    c.this.aZX().a(c.this.eOw, c.this.gXJ);
                }
            }
        };
        this.cfl = tbPageContext;
        this.ds42 = l.getDimens(this.cfl.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cfl.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eGf = (HeadImageView) view.findViewById(R.id.photo);
        this.csn = (TextView) view.findViewById(R.id.user_name);
        this.gXD = (TextView) view.findViewById(R.id.fans_reply);
        this.gXE = (TextView) view.findViewById(R.id.post_from);
        this.gXF = view.findViewById(R.id.divider_between_time_and_post_from);
        this.dyX = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gXG = view.findViewById(R.id.card_message_divider_line);
        this.bcx = (TextView) view.findViewById(R.id.card_message_post_title);
        this.eOw = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gXH = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gXI = view.findViewById(R.id.new_message);
        this.eGf.setOnClickListener(this);
        this.csn.setOnClickListener(this);
        this.gXH.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
            am.setViewTextColor(this.csn, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gXD, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.gXD, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.gXE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dyX, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.gXF, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.gXG, R.color.cp_bg_line_c);
            am.setViewTextColor(this.bcx, (int) R.color.cp_cont_j);
            if (this.eOw != null) {
                this.eOw.onChangeSkinType();
            }
            if (this.gXH != null) {
                this.gXH.onChangeSkinType();
            }
            am.setBackgroundResource(this.gXI, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.gXJ = aVar;
            this.eGf.setVisibility(0);
            this.eGf.setDefaultResource(R.drawable.icon_default_avatar100);
            this.eGf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eGf.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eGf.setIsRound(true);
            this.eGf.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eGf.setTag(null);
            this.eGf.setPageId(this.cfl.getUniqueId());
            this.eGf.startLoad(portrait, 12, false);
            this.csn.setText(aq.cutChineseAndEnglishWithSuffix(aVar.getReplyer().getName_show(), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gXD.setVisibility(0);
            } else {
                this.gXD.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.gXF.setVisibility(0);
                this.gXE.setVisibility(0);
                this.gXE.setText(aVar.getPostFrom());
            } else {
                this.gXF.setVisibility(8);
                this.gXE.setVisibility(8);
            }
            this.dyX.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.avt().b(this.cfl.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.gXG.setVisibility(8);
                this.bcx.setVisibility(8);
            } else {
                this.bcx.setText(a(this.bcx, TbFaceManager.avt().b(this.cfl.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.bcx.setVisibility(0);
                this.gXG.setVisibility(0);
            }
            this.eOw.b(aVar.getOriginalThreadInfo());
            this.eOw.setSubClickListener(this.gXK);
            MessageCardBottomView messageCardBottomView = this.gXH;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gXv || aVar.getType() == a.gXw) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gXI.setVisibility(0);
            } else {
                this.gXI.setVisibility(8);
            }
            onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gXJ != null || this.cfl != null) {
            if (view == this.eGf || view == this.csn) {
                if (this.gXJ.getReplyer() != null) {
                    String userId = this.gXJ.getReplyer().getUserId();
                    String userName = this.gXJ.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cfl.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aZX() != null) {
                aZX().a(view, this.gXJ);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cfl == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cfl.getPageActivity()) - (this.cfl.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
