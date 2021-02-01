package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonalCardItemView extends LinearLayout {
    private int eQj;
    private int eQk;
    private TbImageView llQ;
    private TbImageView llR;
    private Context mContext;
    private View mRootView;
    private ImageView nFU;
    private TbImageView nGJ;
    private TextView nHt;
    private TextView nIl;
    private View nIm;
    private com.baidu.tieba.themeCenter.a nIn;
    private a nIo;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.themeCenter.a aVar);
    }

    public PersonalCardItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.eQj = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eQk = (int) (this.eQj * 0.57d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.personal_card_item_layout, this);
        this.llQ = (TbImageView) this.mRootView.findViewById(R.id.image_bg);
        this.llR = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.llR.setDefaultResource(R.drawable.transparent_bg);
        this.llR.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGJ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nGJ.setDefaultResource(R.drawable.transparent_bg);
        this.nGJ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nFU = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nHt = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nIl = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nIm = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llQ.getLayoutParams();
        layoutParams.height = this.eQk;
        layoutParams.width = this.eQj;
        this.llQ.setLayoutParams(layoutParams);
        this.nIm.setLayoutParams(layoutParams);
        this.llQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nIo != null) {
                    PersonalCardItemView.this.nIo.a(PersonalCardItemView.this.nIn);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nIn = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nFo) {
                this.llQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ap.setBackgroundColor(this.llQ, R.color.CAM_X0204);
                ap.setImageResource(this.llQ, R.drawable.icon_bubble_choose_no);
                this.nHt.setVisibility(0);
                this.nGJ.setVisibility(8);
                this.llR.setVisibility(8);
            } else {
                this.nHt.setVisibility(8);
                this.nGJ.setVisibility(0);
                this.llR.setVisibility(0);
                this.llQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.llQ.setImageBitmap(null);
                this.llQ.setDefaultResource(R.drawable.img_default_100);
                this.llQ.startLoad(aVar.dQO(), 10, false);
            }
            if (aVar.dQR() == 1) {
                this.nFU.setVisibility(0);
                ap.setImageResource(this.nFU, R.drawable.icon_choose_photo);
            } else {
                this.nFU.setVisibility(8);
            }
            this.llR.startLoad(aVar.dQP(), 10, false);
            this.nGJ.startLoad(aVar.dQQ(), 10, false);
            this.nIl.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nIo;
    }

    public void setCardViewController(a aVar) {
        this.nIo = aVar;
    }
}
