package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public long forumId;
    public String forumName;
    public int geK;
    public String gjF;
    public String gjG;
    public String gjH;
    public String gjI;
    public int gjM;
    public int gjN;
    public int gjO;
    public int gjP;
    public String gjQ;
    public int state;
    public String timestamp;
    public int type;
    public boolean gjD = false;
    public boolean gjJ = false;
    public boolean gjK = false;
    public boolean gjL = true;

    public void V(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gjF = intent.getStringExtra("key_input_picture_path");
            this.gjG = intent.getStringExtra("key_input_video_path");
            this.gjI = intent.getStringExtra("key_sticker_path");
            this.gjD = intent.getBooleanExtra("key_need_mute", false);
            this.gjJ = intent.getBooleanExtra("key_need_publish", false);
            this.geK = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gjK = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gjL = intent.getBooleanExtra("key_need_composite", true);
            this.gjQ = TbadkCoreApplication.getCurrentAccount();
            this.gjM = intent.getIntExtra("key_target_width", 0);
            this.gjN = intent.getIntExtra("key_target_height", 0);
            this.gjO = intent.getIntExtra("key_locate_x", 0);
            this.gjP = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
