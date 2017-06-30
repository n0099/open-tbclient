package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ SelectForumActivity ghv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectForumActivity selectForumActivity) {
        this.ghv = selectForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        ImageView imageView;
        TextView textView2;
        List<v> list;
        if (view != null) {
            int id = view.getId();
            textView = this.ghv.gho;
            if (id == textView.getId()) {
                Intent intent = new Intent();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                list = this.ghv.mDataList;
                for (v vVar : list) {
                    if (vVar instanceof TransmitForumData) {
                        arrayList.add((TransmitForumData) vVar);
                    }
                }
                intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                this.ghv.setResult(-1, intent);
                this.ghv.finish();
                return;
            }
            int id2 = view.getId();
            view2 = this.ghv.dyF;
            if (id2 == view2.getId()) {
                this.ghv.setResult(0);
                this.ghv.finish();
                return;
            }
            int id3 = view.getId();
            imageView = this.ghv.ghs;
            if (id3 != imageView.getId()) {
                int id4 = view.getId();
                textView2 = this.ghv.ght;
                if (id4 != textView2.getId()) {
                    return;
                }
            }
            ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.ghv.getPageContext().getPageActivity());
            forumSearchActivityConfig.setRequestCode(25019);
            forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSearchActivityConfig));
            TiebaStatic.log("c12259");
        }
    }
}
