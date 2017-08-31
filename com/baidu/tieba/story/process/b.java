package com.baidu.tieba.story.process;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public int fXN;
    public long forumId;
    public String forumName;
    public String gcG;
    public String gcH;
    public String gcI;
    public String gcJ;
    public int gcN;
    public int gcO;
    public int gcP;
    public int gcQ;
    public String gcR;
    public int state;
    public String timestamp;
    public int type;
    public boolean gcE = false;
    public boolean gcK = false;
    public boolean gcL = false;
    public boolean gcM = true;

    public void ab(Intent intent) {
        if (intent != null) {
            this.type = intent.getIntExtra("key_input_type", 0);
            this.gcG = intent.getStringExtra("key_input_picture_path");
            this.gcH = intent.getStringExtra("key_input_video_path");
            this.gcJ = intent.getStringExtra("key_sticker_path");
            this.gcE = intent.getBooleanExtra("key_need_mute", false);
            this.gcK = intent.getBooleanExtra("key_need_publish", false);
            this.fXN = intent.getIntExtra("key_page_from", 1);
            this.forumId = intent.getLongExtra("key_forum_id", 0L);
            this.forumName = intent.getStringExtra("key_forum_name");
            this.gcL = intent.getBooleanExtra("key_only_publish", false);
            this.state = intent.getIntExtra("key_story_state", 0);
            this.gcM = intent.getBooleanExtra("key_need_composite", true);
            this.gcR = TbadkCoreApplication.getCurrentAccount();
            this.gcN = intent.getIntExtra("key_target_width", 0);
            this.gcO = intent.getIntExtra("key_target_height", 0);
            this.gcP = intent.getIntExtra("key_locate_x", 0);
            this.gcQ = intent.getIntExtra("key_locate_y", 0);
        }
    }
}
