package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fYH;
    public long forumId;
    public String forumName;
    public String gdA;
    public String gdB;
    public String gdC;
    public String gdD;
    public int gdH;
    public int gdI;
    public int gdJ;
    public int gdK;
    public String gdL;
    public int state;
    public String timestamp;
    public int type;
    public boolean gdy = false;
    public boolean gdE = false;
    public boolean gdF = false;
    public boolean gdG = true;

    public void aa(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gdA = intent.getStringExtra("key_input_picture_path");
            this.gdB = intent.getStringExtra("key_input_video_path");
            this.gdD = intent.getStringExtra("key_sticker_path");
            this.gdy = intent.getBooleanExtra("key_need_mute", false);
            this.gdE = intent.getBooleanExtra("key_need_publish", false);
            this.fYH = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gdF = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gdG = intent.getBooleanExtra("key_need_composite", true);
            this.gdL = TbadkCoreApplication.getCurrentAccount();
            this.gdH = intent.getIntExtra("key_target_width", 0);
            this.gdI = intent.getIntExtra("key_target_height", 0);
            this.gdJ = intent.getIntExtra("key_locate_x", 0);
            this.gdK = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
