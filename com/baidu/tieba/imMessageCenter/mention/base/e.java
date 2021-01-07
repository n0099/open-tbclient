package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private ImageView ghE;
    private TextView kPV;
    private TBSpecificationBtn kPW;
    private a kPX;
    private f mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.this.kPW.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(e.this.mContext);
                TiebaStatic.log(new aq("c13705").an("obj_type", 1));
            } else if (view.getId() == e.this.ghE.getId()) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (e.this.kPX != null) {
                    e.this.kPX.onClose();
                }
                TiebaStatic.log(new aq("c13705").an("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes2.dex */
    public interface a {
        void onClose();
    }

    public e(f fVar) {
        this.mContext = fVar;
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.ghE = (ImageView) this.mView.findViewById(R.id.img_close);
        this.ghE.setOnClickListener(this.mOnClickListener);
        this.kPV = (TextView) this.mView.findViewById(R.id.open_desc);
        this.kPW = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.kPW.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.kPW.setText(fVar.getString(R.string.go_to_open));
        this.kPW.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mView, R.color.CAM_X0206);
        SvgManager.bwr().a(this.ghE, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.kPV, R.color.CAM_X0107);
    }

    public void a(a aVar) {
        this.kPX = aVar;
    }
}
