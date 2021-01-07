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
    private TextView dxT;
    private TextView eLt;
    private TbPageContext eXu;
    private TextView gFk;
    private HeadImageView ioZ;
    public OriginalThreadCardView ixo;
    private TextView kPE;
    private TextView kPF;
    private View kPG;
    private View kPH;
    private MessageCardBottomView kPI;
    private View kPJ;
    private a kPK;
    private OriginalThreadCardView.a kPL;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.kPL = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.kPK != null && c.this.kPK.dbw() != null) {
                    aq an = new aq(c.this.kPK.dbw()).an("obj_locate", 2);
                    if (c.this.kPK.getType() == a.kPB || c.this.kPK.getType() == a.kPx) {
                        an.an("obj_type", 1);
                    } else {
                        an.an("obj_type", 2);
                    }
                    TiebaStatic.log(an);
                }
                if (c.this.cuD() != null) {
                    c.this.cuD().a(c.this.ixo, c.this.kPK);
                }
            }
        };
        this.eXu = tbPageContext;
        this.ds42 = l.getDimens(this.eXu.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.eXu.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ioZ = (HeadImageView) view.findViewById(R.id.photo);
        this.eLt = (TextView) view.findViewById(R.id.user_name);
        this.kPE = (TextView) view.findViewById(R.id.fans_reply);
        this.kPF = (TextView) view.findViewById(R.id.post_from);
        this.kPG = view.findViewById(R.id.divider_between_time_and_post_from);
        this.gFk = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.kPH = view.findViewById(R.id.card_message_divider_line);
        this.dxT = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ixo = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.kPI = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.kPJ = view.findViewById(R.id.new_message);
        this.ixo.setUsePlaceHolder(false);
        this.ioZ.setOnClickListener(this);
        this.eLt.setOnClickListener(this);
        this.kPI.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
            ao.setViewTextColor(this.eLt, R.color.CAM_X0106);
            ao.setViewTextColor(this.kPE, R.color.CAM_X0109);
            ao.setBackgroundResource(this.kPE, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ao.setViewTextColor(this.kPF, R.color.CAM_X0109);
            ao.setViewTextColor(this.gFk, R.color.CAM_X0109);
            ao.setBackgroundColor(this.kPG, R.color.CAM_X0110);
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setBackgroundColor(this.kPH, R.color.CAM_X0204);
            ao.setViewTextColor(this.dxT, R.color.CAM_X0107);
            if (this.ixo != null) {
                this.ixo.onChangeSkinType();
            }
            if (this.kPI != null) {
                this.kPI.onChangeSkinType();
            }
            ao.setBackgroundResource(this.kPJ, R.drawable.icon_news_red_dot);
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
            this.kPK = aVar;
            MetaData replyer = aVar.getReplyer();
            this.ioZ.setVisibility(0);
            this.ioZ.setPlaceHolder(1);
            this.ioZ.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.ioZ, replyer, 0);
            this.ioZ.setTag(null);
            this.ioZ.setPageId(this.eXu.getUniqueId());
            this.ioZ.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.eLt.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.kPE.setVisibility(0);
            } else {
                this.kPE.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.kPG.setVisibility(0);
                this.kPF.setVisibility(0);
                this.kPF.setText(aVar.getPostFrom());
            } else {
                this.kPG.setVisibility(8);
                this.kPF.setVisibility(8);
            }
            this.gFk.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bGp().b(this.eXu.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.kPH.setVisibility(8);
                this.dxT.setVisibility(8);
            } else {
                this.dxT.setText(a(this.dxT, TbFaceManager.bGp().b(this.eXu.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.dxT.setVisibility(0);
                this.kPH.setVisibility(0);
            }
            this.ixo.b(aVar.getOriginalThreadInfo());
            this.ixo.setSubClickListener(this.kPL);
            MessageCardBottomView messageCardBottomView = this.kPI;
            String fname = aVar.getFname();
            if (aVar.getType() == a.kPx || aVar.getType() == a.kPy) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.kPJ.setVisibility(0);
            } else {
                this.kPJ.setVisibility(8);
            }
            onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kPK != null || this.eXu != null) {
            if (view == this.ioZ || view == this.eLt) {
                if (this.kPK.getReplyer() != null) {
                    String userId = this.kPK.getReplyer().getUserId();
                    String userName = this.kPK.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eXu.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cuD() != null) {
                cuD().a(view, this.kPK);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.eXu == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.eXu.getPageActivity()) - (this.eXu.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
