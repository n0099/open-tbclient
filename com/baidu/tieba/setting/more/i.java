package com.baidu.tieba.setting.more;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class i extends com.baidu.tbadk.core.dialog.a {
    private EditText lAv;
    private LinearLayout mContentView;

    public i(final Activity activity) {
        super(activity);
        this.mContentView = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_visit_preview_server, (ViewGroup) null);
        aV(this.mContentView);
        this.lAv = (EditText) this.mContentView.findViewById(R.id.et_visit_preview_server_dialog_pub_env_value);
        a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.more.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (!as.isEmpty(i.this.lAv.getText().toString())) {
                    TbSingleton.getInstance().setVisitPreviewServer(true);
                    TbSingleton.getInstance().setPubEnvValue(i.this.lAv.getText().toString());
                    l.showToast(activity, R.string.change_success);
                }
                i.this.dismiss();
            }
        });
        b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.i.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                i.this.dismiss();
            }
        });
    }
}
