package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int eYe;
    public long forumId;
    public String forumName;
    public String gtA;
    public String gtB;
    public int gtF;
    public int gtG;
    public int gtH;
    public int gtI;
    public String gtJ;
    public String gty;
    public String gtz;
    public int state;
    public String timestamp;
    public int type;
    public boolean gtw = false;
    public boolean gtC = false;
    public boolean gtD = false;
    public boolean gtE = true;

    public void Z(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gty = intent.getStringExtra("key_input_picture_path");
            this.gtz = intent.getStringExtra("key_input_video_path");
            this.gtB = intent.getStringExtra("key_sticker_path");
            this.gtw = intent.getBooleanExtra("key_need_mute", false);
            this.gtC = intent.getBooleanExtra("key_need_publish", false);
            this.eYe = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gtD = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gtE = intent.getBooleanExtra("key_need_composite", true);
            this.gtJ = TbadkCoreApplication.getCurrentAccount();
            this.gtF = intent.getIntExtra("key_target_width", 0);
            this.gtG = intent.getIntExtra("key_target_height", 0);
            this.gtH = intent.getIntExtra("key_locate_x", 0);
            this.gtI = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
