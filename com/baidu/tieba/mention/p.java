package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private Context context;
    private String id;
    private String name;

    public p(Context context) {
        setId(null);
        setName(null);
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.id != null && this.id.length() > 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.context, this.id, this.name)));
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setId(String str) {
        this.id = str;
    }
}
