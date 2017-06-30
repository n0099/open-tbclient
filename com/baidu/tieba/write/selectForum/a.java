package com.baidu.tieba.write.selectForum;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ HotTopicChangeFourmActivity ghj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.ghj = hotTopicChangeFourmActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        Intent intent = new Intent();
        intent.putExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, i);
        list = this.ghj.mList;
        intent.putExtra(VideoListActivityConfig.KEY_FORUM_ID, ((HotTopicBussinessData) list.get(i)).getForumId());
        list2 = this.ghj.mList;
        intent.putExtra("KEY_FORUM_NAME", ((HotTopicBussinessData) list2.get(i)).getForumName());
        this.ghj.setResult(-1, intent);
        this.ghj.finish();
    }
}
