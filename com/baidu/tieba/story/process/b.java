package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int eZh;
    public long forumId;
    public String forumName;
    public String gwf;
    public String gwg;
    public String gwh;
    public String gwi;
    public int gwm;
    public int gwn;
    public int gwo;
    public int gwp;
    public String gwq;
    public int state;
    public String timestamp;
    public int type;
    public boolean gwd = false;
    public boolean gwj = false;
    public boolean gwk = false;
    public boolean gwl = true;

    public void Z(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gwf = intent.getStringExtra("key_input_picture_path");
            this.gwg = intent.getStringExtra("key_input_video_path");
            this.gwi = intent.getStringExtra("key_sticker_path");
            this.gwd = intent.getBooleanExtra("key_need_mute", false);
            this.gwj = intent.getBooleanExtra("key_need_publish", false);
            this.eZh = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gwk = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gwl = intent.getBooleanExtra("key_need_composite", true);
            this.gwq = TbadkCoreApplication.getCurrentAccount();
            this.gwm = intent.getIntExtra("key_target_width", 0);
            this.gwn = intent.getIntExtra("key_target_height", 0);
            this.gwo = intent.getIntExtra("key_locate_x", 0);
            this.gwp = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
