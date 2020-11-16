package com.baidu.tieba.setting.more;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class i extends com.baidu.tbadk.core.dialog.a {
    private LinearLayout mContentView;
    private EditText mJV;

    public i(final Activity activity) {
        super(activity);
        this.mContentView = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_visit_preview_server, (ViewGroup) null);
        bg(this.mContentView);
        this.mJV = (EditText) this.mContentView.findViewById(R.id.et_visit_preview_server_dialog_pub_env_value);
        a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.more.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (!au.isEmpty(i.this.mJV.getText().toString())) {
                    TbSingleton.getInstance().setVisitPreviewServer(true);
                    String obj = i.this.mJV.getText().toString();
                    TbSingleton.getInstance().setPubEnvValue(obj);
                    l.showToast(activity, R.string.change_success);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921508, obj));
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
