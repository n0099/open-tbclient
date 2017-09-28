package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fWl;
    public long forumId;
    public String forumName;
    public String gbh;
    public String gbi;
    public String gbj;
    public String gbk;
    public int gbo;
    public int gbp;
    public int gbq;
    public int gbr;
    public String gbs;
    public int state;
    public String timestamp;
    public int type;
    public boolean gbf = false;
    public boolean gbl = false;
    public boolean gbm = false;
    public boolean gbn = true;

    public void W(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gbh = intent.getStringExtra("key_input_picture_path");
            this.gbi = intent.getStringExtra("key_input_video_path");
            this.gbk = intent.getStringExtra("key_sticker_path");
            this.gbf = intent.getBooleanExtra("key_need_mute", false);
            this.gbl = intent.getBooleanExtra("key_need_publish", false);
            this.fWl = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gbm = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gbn = intent.getBooleanExtra("key_need_composite", true);
            this.gbs = TbadkCoreApplication.getCurrentAccount();
            this.gbo = intent.getIntExtra("key_target_width", 0);
            this.gbp = intent.getIntExtra("key_target_height", 0);
            this.gbq = intent.getIntExtra("key_locate_x", 0);
            this.gbr = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
