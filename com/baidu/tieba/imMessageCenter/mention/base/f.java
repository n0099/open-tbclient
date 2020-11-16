package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f {
    private ImageView fPM;
    private TextView kxr;
    private TBSpecificationBtn kxs;
    private a kxt;
    private com.baidu.adp.base.e mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == f.this.kxs.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(f.this.mContext);
                TiebaStatic.log(new ar("c13705").ak("obj_type", 1));
            } else if (view.getId() == f.this.fPM.getId()) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (f.this.kxt != null) {
                    f.this.kxt.onClose();
                }
                TiebaStatic.log(new ar("c13705").ak("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes21.dex */
    public interface a {
        void onClose();
    }

    public f(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.fPM = (ImageView) this.mView.findViewById(R.id.img_close);
        this.fPM.setOnClickListener(this.mOnClickListener);
        this.kxr = (TextView) this.mView.findViewById(R.id.open_desc);
        this.kxs = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.kxs.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.kxs.setText(eVar.getString(R.string.go_to_open));
        this.kxs.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mView, R.color.CAM_X0206);
        SvgManager.bqB().a(this.fPM, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.kxr, R.color.CAM_X0107);
    }

    public void a(a aVar) {
        this.kxt = aVar;
    }
}
