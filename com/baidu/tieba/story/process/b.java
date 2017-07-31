package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fXp;
    public long forumId;
    public String forumName;
    public String gce;
    public String gcf;
    public String gcg;
    public String gch;
    public int gcl;
    public int gcm;
    public int gcn;
    public int gco;
    public String gcp;
    public int state;
    public String timestamp;
    public int type;
    public boolean gcc = false;
    public boolean gci = false;
    public boolean gcj = false;
    public boolean gck = true;

    public void Y(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gce = intent.getStringExtra("key_input_picture_path");
            this.gcf = intent.getStringExtra("key_input_video_path");
            this.gch = intent.getStringExtra("key_sticker_path");
            this.gcc = intent.getBooleanExtra("key_need_mute", false);
            this.gci = intent.getBooleanExtra("key_need_publish", false);
            this.fXp = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gcj = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gck = intent.getBooleanExtra("key_need_composite", true);
            this.gcp = TbadkCoreApplication.getCurrentAccount();
            this.gcl = intent.getIntExtra("key_target_width", 0);
            this.gcm = intent.getIntExtra("key_target_height", 0);
            this.gcn = intent.getIntExtra("key_locate_x", 0);
            this.gco = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
