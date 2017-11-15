package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public long forumId;
    public String forumName;
    public int gfM;
    public String gkH;
    public String gkI;
    public String gkJ;
    public String gkK;
    public int gkO;
    public int gkP;
    public int gkQ;
    public int gkR;
    public String gkS;
    public int state;
    public String timestamp;
    public int type;
    public boolean gkF = false;
    public boolean gkL = false;
    public boolean gkM = false;
    public boolean gkN = true;

    public void V(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gkH = intent.getStringExtra("key_input_picture_path");
            this.gkI = intent.getStringExtra("key_input_video_path");
            this.gkK = intent.getStringExtra("key_sticker_path");
            this.gkF = intent.getBooleanExtra("key_need_mute", false);
            this.gkL = intent.getBooleanExtra("key_need_publish", false);
            this.gfM = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gkM = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gkN = intent.getBooleanExtra("key_need_composite", true);
            this.gkS = TbadkCoreApplication.getCurrentAccount();
            this.gkO = intent.getIntExtra("key_target_width", 0);
            this.gkP = intent.getIntExtra("key_target_height", 0);
            this.gkQ = intent.getIntExtra("key_locate_x", 0);
            this.gkR = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
