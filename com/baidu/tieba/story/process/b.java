package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fVW;
    public long forumId;
    public String forumName;
    public String gaS;
    public String gaT;
    public String gaU;
    public String gaV;
    public int gaZ;
    public int gba;
    public int gbb;
    public int gbc;
    public String gbd;
    public int state;
    public String timestamp;
    public int type;
    public boolean gaQ = false;
    public boolean gaW = false;
    public boolean gaX = false;
    public boolean gaY = true;

    public void W(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gaS = intent.getStringExtra("key_input_picture_path");
            this.gaT = intent.getStringExtra("key_input_video_path");
            this.gaV = intent.getStringExtra("key_sticker_path");
            this.gaQ = intent.getBooleanExtra("key_need_mute", false);
            this.gaW = intent.getBooleanExtra("key_need_publish", false);
            this.fVW = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gaX = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gaY = intent.getBooleanExtra("key_need_composite", true);
            this.gbd = TbadkCoreApplication.getCurrentAccount();
            this.gaZ = intent.getIntExtra("key_target_width", 0);
            this.gba = intent.getIntExtra("key_target_height", 0);
            this.gbb = intent.getIntExtra("key_locate_x", 0);
            this.gbc = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
