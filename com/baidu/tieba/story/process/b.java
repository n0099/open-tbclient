package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fZj;
    public long forumId;
    public String forumName;
    public String gdW;
    public String gdX;
    public String gdY;
    public String gdZ;
    public int ged;
    public int gee;
    public int gef;
    public int geg;
    public String geh;
    public int state;
    public String timestamp;
    public int type;
    public boolean gdU = false;
    public boolean gea = false;
    public boolean geb = false;
    public boolean gec = true;

    public void aa(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gdW = intent.getStringExtra("key_input_picture_path");
            this.gdX = intent.getStringExtra("key_input_video_path");
            this.gdZ = intent.getStringExtra("key_sticker_path");
            this.gdU = intent.getBooleanExtra("key_need_mute", false);
            this.gea = intent.getBooleanExtra("key_need_publish", false);
            this.fZj = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.geb = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gec = intent.getBooleanExtra("key_need_composite", true);
            this.geh = TbadkCoreApplication.getCurrentAccount();
            this.ged = intent.getIntExtra("key_target_width", 0);
            this.gee = intent.getIntExtra("key_target_height", 0);
            this.gef = intent.getIntExtra("key_locate_x", 0);
            this.geg = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
